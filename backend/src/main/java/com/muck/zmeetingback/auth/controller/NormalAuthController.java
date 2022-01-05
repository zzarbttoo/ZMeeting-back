package com.muck.zmeetingback.auth.controller;

import com.muck.zmeetingback.auth.dto.NormalLoginDTO;
import com.muck.zmeetingback.auth.dto.NormalUserDTO;
import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import com.muck.zmeetingback.auth.service.NormalAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        return normalAuthService.isNormalUser(loginId);
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<WholeUserDTO> normalSignUp(NormalUserDTO request){

        WholeUserDTO userDTO = normalAuthService.signUp(request);

        //TODO : success, fail 객체 만들어서 전달하기

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }


    @PostMapping(value = "/sign-in")
    public ResponseEntity<?> normalSignIn(@RequestBody NormalLoginDTO normalLoginDTO){

        //TODO : success, fail 객체 만들어서 전달하기
        //TODO : JWT Token 발급

        try {
            WholeUserDTO userDTO = normalAuthService.signIn(normalLoginDTO);
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
