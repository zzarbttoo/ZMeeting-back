package com.muck.zmeetingback.auth.service;

import com.muck.zmeetingback.auth.dto.TokenDTO;
import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import com.muck.zmeetingback.jpa.entity.RefreshTokenEntity;
import com.muck.zmeetingback.jpa.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Transactional
    public void saveRefreshToken(TokenDTO tokenDTO, WholeUserDTO userDTO){

        RefreshTokenEntity refreshTokenEntity = RefreshTokenEntity.builder().key(userDTO.getLoginId())
                .value(tokenDTO.getRefreshToken())
                .refreshTokenExpiredDate(tokenDTO.getRefreshTokenExpiresIn())
                .build();

        tokenRepository.save(refreshTokenEntity);
    }

}
