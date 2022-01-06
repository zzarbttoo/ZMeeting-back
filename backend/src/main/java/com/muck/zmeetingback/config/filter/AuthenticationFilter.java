package com.muck.zmeetingback.config.filter;

import com.muck.zmeetingback.auth.service.NormalAuthServiceImpl;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final NormalAuthServiceImpl normalAuthService;
    private final Environment env;

    public AuthenticationFilter(AuthenticationManager authenticationManager
            , NormalAuthServiceImpl normalAuthService, Environment env){

        super.setAuthenticationManager(authenticationManager);
        this.normalAuthService = normalAuthService;
        this.env = env;

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain
            , Authentication authResult) throws IOException, ServletException {


    }
}

