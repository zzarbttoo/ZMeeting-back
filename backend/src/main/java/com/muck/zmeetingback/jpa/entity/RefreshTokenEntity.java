package com.muck.zmeetingback.jpa.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "REFRESH_TOKEN")
@Entity
public class RefreshTokenEntity {

    @Id
    @Column(name = "USER_ID")
    private String userId; //id

    @Column(name = "REFRESH_TOKEN_VALUE")
    private String refreshTokenValue; //value

    @Column(name = "REFRESH_TOKEN_EXPIRED_DATE")
    private Timestamp refreshTokenExpiredDate;

    public RefreshTokenEntity updateToken(String token, Date refreshTokenExpiredDate){
        this.refreshTokenValue = token;
        this.refreshTokenExpiredDate = new Timestamp(refreshTokenExpiredDate.getTime());
        return this;
    }

    @Builder //자동으로 builder 추가
    public RefreshTokenEntity(String key, String value, Date refreshTokenExpiredDate) {
        this.userId = key;
        this.refreshTokenValue = value;
        this.refreshTokenExpiredDate = new Timestamp(refreshTokenExpiredDate.getTime());
    }
}
