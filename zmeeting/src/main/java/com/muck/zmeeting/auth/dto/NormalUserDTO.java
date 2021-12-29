package com.muck.zmeeting.auth.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
public class UserDTO {

    @Nullable
    private int userIndex;

    @Nullable
    private String id;

    @Nullable
    private String password;

    @Nullable
    private String thirdPartyEmail; //kakao, google email

    @NonNull
    private String nickName;

    @Nullable
    private String name;

    @Nullable
    private String gender;

    @Nullable
    private Date birth;

    @Nullable
    private int 

    @Nullable
    private String profileURI;

    @Nullable
    private String country;

    @Nullable
    private String loginKind; //normal, kakao, google





}
