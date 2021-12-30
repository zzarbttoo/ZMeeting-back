package com.muck.zmeetingback.auth.service;

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

    public Optional<WholeUserDTO> isNormalUser(String loginId){

        return userRepository.findUserEntityByLoginId(loginId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public WholeUserDTO signUp(NormalUserDTO normalUserDTO){

        //암호화
        normalUserDTO.setPassword(passwordEncoder.encode(normalUserDTO.getPassword()));

        ModelMapper mapper = customModelMapper.dtoToEntityMapper();
        UserEntity userEntity = mapper.map(normalUserDTO, UserEntity.class);
        userEntity.changeLoginKind(NORMAL_LOGIN_TYPE);

        userRepository.save(userEntity);

        //파일 업로드 진행
        if (normalUserDTO.getProfileImage() != null){

            UUID uuid = UUID.randomUUID();
            FileSystemStorageService fileService = new FileSystemStorageService(IMAGE_PATH, uuid);
            String fileName = fileService.store(normalUserDTO.getProfileImage());

            ImageEntity imageEntity = new ImageEntity(IMAGE_PATH, fileName, Boolean.TRUE);
            imageEntity.setUserEntity(userEntity);

            imageRepository.save(imageEntity);

        }

        //TODO : return DTO
        return null;

    }


}
