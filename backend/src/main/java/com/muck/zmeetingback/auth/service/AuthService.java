package com.muck.zmeetingback.auth.service;

import com.muck.zmeetingback.auth.dto.LoginSuccess;
import com.muck.zmeetingback.auth.dto.NormalLoginDTO;
import com.muck.zmeetingback.auth.dto.NormalUserDTO;
import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    public Boolean isNormalUser(String loginId);
    public WholeUserDTO signUp(NormalUserDTO normalUserDTO) throws Exception;
    public LoginSuccess signIn(NormalLoginDTO normalLoginDTO) throws Exception;


}
