package com.zzarbttoo.springbootwebrtc.auth.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GoogleLoginInformDTO {

    private String userId;
    private String email;
    private String name;
    private String pictureUrl;
    private String locale;
    private String familyName;
    private String givenName;

}
