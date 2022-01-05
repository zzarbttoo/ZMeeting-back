package com.muck.zmeetingback.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeyFile {

    public static final String NORMAL_LOGIN_TYPE = "normal";
    public static final String GOOGLE_LOGIN_TYPE = "google";
    public static final String KAKAO_LOGIN_TYPE = "kakao";

    public static String IMAGE_PATH;


    @Value("${image.path}")
    public void setImagePath(String imagePath){

        IMAGE_PATH = imagePath;
    }




}
