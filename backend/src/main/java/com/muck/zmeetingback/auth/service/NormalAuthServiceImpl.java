package com.muck.zmeetingback.auth.service;

import com.muck.zmeetingback.auth.dto.*;
import com.muck.zmeetingback.jpa.entity.ImageEntity;
import com.muck.zmeetingback.jpa.entity.UserEntity;
import com.muck.zmeetingback.jpa.repository.ImageRepository;
import com.muck.zmeetingback.jpa.repository.UserRepository;
import com.muck.zmeetingback.util.CustomModelMapper;
import com.muck.zmeetingback.util.JwtTokenProvider;
import com.muck.zmeetingback.util.fileupload.FileSystemStorageService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.muck.zmeetingback.util.KeyFile.IMAGE_PATH;
import static com.muck.zmeetingback.util.KeyFile.NORMAL_LOGIN_TYPE;

@Service
@Slf4j
public class NormalAuthServiceImpl implements AuthService{

    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final CustomModelMapper customModelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final JwtTokenProvider provider;


    public NormalAuthServiceImpl(ImageRepository imageRepository, UserRepository userRepository
            , CustomModelMapper customModelMapper, BCryptPasswordEncoder passwordEncoder
            , TokenService tokenService, JwtTokenProvider provider) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.customModelMapper = customModelMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.provider = provider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userOptional = userRepository.findUserEntityByLoginId(username);

        if (userOptional.isEmpty()){
            throw new UsernameNotFoundException(username);
        }

        UserEntity userEntity = userOptional.get();

        return new User(userEntity.getLoginId(), userEntity.getPassword(), true, true
                , true, true, new ArrayList<>());

    }

    @Override
    public Boolean isNormalUser(String loginId){

        return userRepository.findUserEntityByLoginId(loginId).isPresent();
    }

    @Override
    @Transactional
    public LoginSuccess signUp(NormalUserDTO normalUserDTO) throws Exception {

        if (isNormalUser(normalUserDTO.getLoginId()) == Boolean.TRUE){
            throw new Exception("이미 존재하는 아이디 입니다");
        }

        //암호화
        normalUserDTO.setPassword(passwordEncoder.encode(normalUserDTO.getPassword()));

        UserEntity userEntity = customModelMapper.dtoToEntityMapper().map(normalUserDTO, UserEntity.class);
        userEntity.changeLoginKind(NORMAL_LOGIN_TYPE);

        userRepository.save(userEntity);


        //파일 업로드 진행
        if (normalUserDTO.getProfileImage() != null){

            log.info(IMAGE_PATH);

            UUID uuid = UUID.randomUUID();
            FileSystemStorageService fileService = new FileSystemStorageService(IMAGE_PATH, uuid);
            String fileName = fileService.store(normalUserDTO.getProfileImage());

            ImageEntity imageEntity = new ImageEntity(IMAGE_PATH, fileName, Boolean.TRUE);
            imageEntity.setUserEntity(userEntity);

            imageRepository.save(imageEntity);

        }

        WholeUserDTO userDTO = customModelMapper.strictMapper().map(userEntity, WholeUserDTO.class);
        TokenDTO tokenDTO = provider.createToken(userDTO, new Date());
        tokenService.saveRefreshToken(tokenDTO, userDTO);

        LoginSuccess loginSuccess = new LoginSuccess(userDTO, tokenDTO);

        return loginSuccess;

    }

    @Override
    public LoginSuccess signIn(NormalLoginDTO normalLoginDTO) throws Exception {

        Optional<UserEntity> member = userRepository.findUserEntityByLoginId(normalLoginDTO.getLoginId());

        if(member.isPresent()){

            //password 일치
            if (passwordEncoder.matches(normalLoginDTO.getPassword(), member.get().getPassword())){

                WholeUserDTO userDTO = customModelMapper.strictMapper().map(member.get(), WholeUserDTO.class);
                TokenDTO tokenDTO = provider.createToken(userDTO, new Date());

                LoginSuccess loginSuccess = new LoginSuccess(userDTO, tokenDTO);

                //TODO : 비동기 처리
                tokenService.saveRefreshToken(tokenDTO, userDTO);

                return loginSuccess;

            }else{
                throw new Exception("password 일치 X");
            }
        }else{
            throw new Exception("해당 아이디 없음");
        }
    }
}
