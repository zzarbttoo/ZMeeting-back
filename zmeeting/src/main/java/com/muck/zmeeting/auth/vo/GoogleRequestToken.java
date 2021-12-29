package com.muck.zmeeting.auth.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestGoogleToken {

    @NonNull
    @JsonProperty("id_token")
    private String idToken;


}