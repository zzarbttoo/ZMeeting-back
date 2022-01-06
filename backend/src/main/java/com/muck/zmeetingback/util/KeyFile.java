package com.muck.zmeetingback.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeyFile {

    public static final String NORMAL_LOGIN_TYPE = "normal";
    public static final String GOOGLE_LOGIN_TYPE = "google";
    public static final String KAKAO_LOGIN_TYPE = "kakao";


    public static final String SIGN_UP_SUCCESS = "sign up and login Success";
    public static final String LOGIN_SUCCESS = "login Success";



    public static String IMAGE_PATH;

    //Token
    public static final String AUTH_KEY = "auth";
    public static final String BEARER_TYPE = "bearer";

    public static final String ROLE_USER = "ROLE_USER";

    public static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30; //30분
    public static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7; //7일
    public static String JWT_KEY;



    @Value("${image.path}")
    public void setImagePath(String imagePath){

        IMAGE_PATH = imagePath;
    }

    @Value("${secret.jwt.key}")
    public void setJwtKey(String jwtKey) {
        JWT_KEY = jwtKey;
    }
}
