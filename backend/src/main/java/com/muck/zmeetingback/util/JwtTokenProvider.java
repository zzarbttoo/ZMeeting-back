package com.muck.zmeetingback.util;

import com.muck.zmeetingback.auth.dto.TokenDTO;
import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyStore;
import java.util.Date;

import static com.muck.zmeetingback.util.KeyFile.*;

@Component
public class JwtTokenProvider {

    //TODO : key encode decode 작업 추가

    public TokenDTO createToken(WholeUserDTO userDTO, Date now) {
        long accessTokenExpireTime = now.getTime() + ACCESS_TOKEN_EXPIRE_TIME;
        long refreshTokenExpireTime = now.getTime() + REFRESH_TOKEN_EXPIRE_TIME;
        String accessToken = Jwts.builder()
                .claim(AUTH_KEY, ROLE_USER)
                .setIssuedAt(now)
                .setExpiration(new Date(accessTokenExpireTime))
                .signWith(SignatureAlgorithm.HS256, JWT_KEY)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS256, JWT_KEY)
                .compact();

        return TokenDTO.builder()
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiresIn(new Date(accessTokenExpireTime))
                .refreshTokenExpiresIn(new Date(refreshTokenExpireTime))
                .build();

    }








}