package com.muck.zmeetingback.auth.service;

import com.muck.zmeetingback.auth.dto.NormalLoginDTO;
import com.muck.zmeetingback.jpa.entity.UserEntity;
import com.muck.zmeetingback.jpa.repository.UserRepository;
import com.muck.zmeetingback.jpa.repository.UserRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.awt.image.BandCombineOp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class NormalAuthServiceTest {


    private final UserRepository userRepository;
    private final NormalAuthService normalAuthService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public NormalAuthServiceTest(UserRepository userRepository, NormalAuthService normalAuthService
            , BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.normalAuthService = normalAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void normalSignUpNoPictureTest(){



    }

    @Test
    public void normalSignUpPictureTest(){

    }

    @Test
    public void signInTest(){

        String encryptedPassword = passwordEncoder.encode("zzarbzzarb");
        //내용 추가
        UserEntity userEntity = new UserEntity("qodbwls70@naver.com"
                , encryptedPassword, "zzarbttoo");

        userRepository.save(userEntity);

        NormalLoginDTO normalLoginDTO = new NormalLoginDTO();
        normalLoginDTO.setLoginId("qodbwls70@naver.com");
        normalLoginDTO.setPassword("zzarbzzarb");

        try {
            normalAuthService.signIn(normalLoginDTO);
        } catch (Exception e) {
            log.info(e.getMessage());
        }


    }
}