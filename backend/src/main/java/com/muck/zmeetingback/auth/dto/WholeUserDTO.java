package com.muck.zmeetingback.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WholeUserDTO {

    private String loginId;
    private String nickName;
    private String gender;
    private Date birth;
    private String country;


}
