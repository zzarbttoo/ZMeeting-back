package com.muck.zmeetingback.util;

import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class JwtTokenProviderTest {

    @Test
    public void createTokenTest(){

        WholeUserDTO userDTO = new WholeUserDTO();
        userDTO.setLoginId("zzarbttoo");
        userDTO.setNickName("zzarbttoo");

        log.info(userDTO.toString());

        JwtTokenProvider provider = new JwtTokenProvider();

        log.info(provider.createToken(userDTO, new Date()).toString());


    }

}