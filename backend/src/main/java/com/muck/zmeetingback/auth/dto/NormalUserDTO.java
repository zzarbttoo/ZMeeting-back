package com.muck.zmeetingback.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NormalUserDTO {

    @NonNull
    private String loginId;

    @NonNull
    private String password;

    @NonNull
    private String nickName;

    private String gender;
    private Date birth;
    private String country;
    private MultipartFile profileImage;

}
