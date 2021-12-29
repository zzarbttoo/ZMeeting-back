package com.muck.zmeeting.auth.jpa.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "THIRD_PARTY_LOGIN_ID")
    private String thirdPartyLoginId; //kakao, google email

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "TOKEN_ISSUED_TIME")
    private Date tokenIssuedTime;

    @Column(name = "SCOPE")
    private String scope;

    @Column(name = "LOGIN_KIND")
    private String loginKind; //kakao, google

    @Column(name = "ID")
    private String id;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NICKNAME")
    private String nickName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH")
    private Date birth;

    @Column(name = "AGE_GROUP")
    private int ageGroup;

    @Column(name = "PROFILE_ID")
    private long profileId; //foreign key 걸기

    @Column(name = "COUNTRY")
    private String country;

}
