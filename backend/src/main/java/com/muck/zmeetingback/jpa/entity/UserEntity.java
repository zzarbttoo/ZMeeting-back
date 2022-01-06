package com.muck.zmeetingback.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "PRIVATE_ID")
    private String privateId; //google, kakao unique Id

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH")
    private Date birth;

    @Column(name = "AGE")
    private String age;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "LOGIN_KIND")
    private String loginKind;

    //google, kakao
    @Column(name = "THIRD_PARTY_KEY_ID")
    private String thirdPartyKeyId;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "SCOPE")
    private String scope;

    @Column(name = "TOKEN_ISSUED_TIME")
    private Date tokenIssuedTime;

    //game
    @OneToMany(mappedBy = "userEntity")
    private List<GameEntity> gamePlayList = new ArrayList<>();

    //image
    @OneToMany(mappedBy = "userEntity")
    private List<ImageEntity> imageList = new ArrayList<>();


    public UserEntity(String loginId, String password, String nickName) {
        this.loginId = loginId;
        this.password = password;
        this.nickName = nickName;
    }

    public void changeLoginKind(String loginKind){
        this.loginKind = loginKind;
    }


}
