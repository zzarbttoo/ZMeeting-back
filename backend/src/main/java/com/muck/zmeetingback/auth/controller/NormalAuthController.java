package com.muck.zmeetingback.auth.controller;

import com.muck.zmeetingback.auth.dto.*;
import com.muck.zmeetingback.auth.service.NormalAuthServiceImpl;
import com.muck.zmeetingback.auth.service.TokenService;
import com.muck.zmeetingback.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.muck.zmeetingback.util.KeyFile.LOGIN_SUCCESS;
import static com.muck.zmeetingback.util.KeyFile.SIGN_UP_SUCCESS;

@RestController
@RequestMapping("/auth/normal/")
@Slf4j
@RequiredArgsConstructor
public class NormalAuthController {

    private final NormalAuthServiceImpl normalAuthService;
    private final TokenService tokenService;
    private final JwtTokenProvider provider;

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/user/{login-id}")
    public Boolean isNormalUser(@PathVariable("login-id") String loginId){
        return normalAuthService.isNormalUser(loginId);
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<?> normalSignUp(NormalUserDTO request){

        LoginSuccess loginSuccess = null;

        try {
            loginSuccess = normalAuthService.signUp(request);
            loginSuccess.setRequestMessage(SIGN_UP_SUCCESS);
            return ResponseEntity.status(HttpStatus.CREATED).body(loginSuccess);

        } catch (Exception e) {
            RequestFail fail = new RequestFail(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fail);
        }

    }


    @PutMapping(value = "/sign-in")
    public ResponseEntity<?> normalSignIn(@RequestBody NormalLoginDTO normalLoginDTO){

        try {

            LoginSuccess loginSuccess = normalAuthService.signIn(normalLoginDTO);
            loginSuccess.setRequestMessage(LOGIN_SUCCESS);
            return ResponseEntity.status(HttpStatus.OK).body(loginSuccess);

        } catch (Exception e) {
            RequestFail fail = new RequestFail(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fail);
        }

    }


}
