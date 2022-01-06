package com.muck.zmeetingback.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TokenDTO {

    private String accessToken;
    private String refreshToken;
    private String grantType;
    private Date accessTokenExpiresIn;
    private Date refreshTokenExpiresIn;

    @Builder
    public TokenDTO(String accessToken, String refreshToken, String grantType
            , Date accessTokenExpiresIn, Date refreshTokenExpiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.grantType = grantType;
        this.accessTokenExpiresIn = accessTokenExpiresIn;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }
}
