package com.muck.zmeetingback.auth.controller;

import com.muck.zmeetingback.auth.vo.NormalSignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/auth/normal")
@Slf4j
public class NormalAuthController {

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }


    //TODO : string -> DTO
    @PostMapping(value = "/sign-up")
    public ResponseEntity<String> normalSignUp(NormalSignUpRequest request){

        log.info("hell");

        return null;
    }



}
