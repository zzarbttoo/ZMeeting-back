package com.muck.zmeeting.auth.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.lang.Nullable;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@Data
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SignUpSession {

    @NonNull
    private String thirdPartyLoginId; //kakao, google email

    @NonNull
    private String accessToken; //google : idToken

    @Nullable
    private String refreshToken;

    @Nullable
    private Date tokenIssuedTime;

    @Nullable
    private String scope;


}
