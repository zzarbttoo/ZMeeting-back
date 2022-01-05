package com.muck.zmeetingback.auth.service;

import com.muck.zmeetingback.auth.dto.NormalLoginDTO;
import com.muck.zmeetingback.auth.dto.NormalUserDTO;
import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import com.muck.zmeetingback.jpa.entity.ImageEntity;
import com.muck.zmeetingback.jpa.entity.UserEntity;
import com.muck.zmeetingback.jpa.repository.ImageRepository;
import com.muck.zmeetingback.jpa.repository.UserRepository;
import com.muck.zmeetingback.util.CustomModelMapper;
import com.muck.zmeetingback.util.fileupload.FileSystemStorageService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.MessageHandler;
import java.util.Optional;
import java.util.UUID;

import static com.muck.zmeetingback.util.KeyFile.IMAGE_PATH;
import static com.muck.zmeetingback.util.KeyFile.NORMAL_LOGIN_TYPE;

@Service
@Slf4j
public class NormalAuthService {

    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final CustomModelMapper customModelMapper;
    private final BCryptPasswordEncoder passwordEncoder;


    public NormalAuthService(ImageRepository imageRepository,
                             UserRepository userRepository,
                             CustomModelMapper customModelMapper,
                             BCryptPasswordEncoder passwordEncoder) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.customModelMapper = customModelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Boolean isNormalUser(String loginId){

        return userRepository.findUserEntityByLoginId(loginId).isPresent();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public WholeUserDTO signUp(NormalUserDTO normalUserDTO){

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

        return customModelMapper.strictMapper().map(userEntity, WholeUserDTO.class);

    }


    public WholeUserDTO signIn(NormalLoginDTO normalLoginDTO) throws Exception {

        Optional<UserEntity> member = userRepository.findUserEntityByLoginId(normalLoginDTO.getLoginId());

        if(member.isPresent()){

            //password 일치
            if (passwordEncoder.matches(normalLoginDTO.getPassword(), member.get().getPassword())){
                return customModelMapper.strictMapper().map(member.get(), WholeUserDTO.class);
            }else{
                throw new Exception("password 일치 X");
            }
        }else{
            throw new Exception("해당 아이디 없음");
        }
    }
}
