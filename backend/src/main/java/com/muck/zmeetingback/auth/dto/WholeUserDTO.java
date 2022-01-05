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

    private Long userId;
    private String nickName;
    private String gender;
    private Date birth;
    private String country;


}
