package com.muck.zmeetingback.config.filter;

import com.muck.zmeetingback.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {


    private final JwtTokenProvider tokenProvider;

    @Autowired
    public JWTFilter(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {



    }
}
