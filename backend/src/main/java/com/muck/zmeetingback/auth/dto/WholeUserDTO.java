package com.muck.zmeetingback.auth.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class WholeUserDTO {

    private String loginId;
    private String password;
    private String nickName;
    private String gender;
    private Date birth;
    private String country;


}
