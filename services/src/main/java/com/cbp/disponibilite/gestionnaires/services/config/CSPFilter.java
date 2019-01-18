package com.cbp.disponibilite.gestionnaires.services.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSPFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        httpServletResponse.setHeader("Content-Security-Policy", "" +
                "default-src 'self'; " +
                "style-src 'self' 'unsafe-inline' fonts.googleapis.com; " +
                "script-src 'self' fonts.googleapis.com; " +
                "img-src data: 'self' online.swagger.io; " +
                "font-src 'self' fonts.gstatic.com");

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
