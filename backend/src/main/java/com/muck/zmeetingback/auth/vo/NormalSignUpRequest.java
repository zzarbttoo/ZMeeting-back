package com.muck.zmeetingback.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NormalSignUpRequest {

    private String loginId;
    private String password;
    private String nickName;
    private String gender;
    private Date birth;
    private String country;
    private MultipartFile profileImage;

}
