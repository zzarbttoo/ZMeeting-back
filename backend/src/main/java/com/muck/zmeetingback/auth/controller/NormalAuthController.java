package com.muck.zmeetingback.auth.controller;

import com.muck.zmeetingback.auth.dto.NormalUserDTO;
import com.muck.zmeetingback.auth.service.NormalAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/normal/")
@Slf4j
@RequiredArgsConstructor
public class NormalAuthController {

    private final NormalAuthService normalAuthService;

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/user/{login-id}")
    public Boolean isNormalUser(@PathVariable("login-id") String loginId){
        return normalAuthService.isNormalUser(loginId).isPresent();
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<String> normalSignUp(NormalUserDTO request){

        normalAuthService.signUp(request);

        return null;
    }



}
