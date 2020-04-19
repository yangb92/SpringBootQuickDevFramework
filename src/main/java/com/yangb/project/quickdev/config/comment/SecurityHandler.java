package com.yangb.project.quickdev.config.comment;

import com.alibaba.fastjson.JSON;
import com.yangb.project.quickdev.common.ResultVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * SpringSecurity处理器
 * Create by YangBin on 2020/4/19
 * Copyright © 2020 YangBin. All rights reserved.
 */
@Component
public class SecurityHandler implements AuthenticationSuccessHandler,LogoutSuccessHandler, AuthenticationFailureHandler, AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResultVo.makeFailed("请登陆后访问")));
        out.flush();
        out.close();
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResultVo result = ResultVo.makeFailed(exception.getMessage());
        out.write(JSON.toJSONString(result));
        out.flush();
        out.close();
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResultVo result = ResultVo.makeSuccess("退出成功");
        out.write(JSON.toJSONString(result));
        out.flush();
        out.close();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResultVo.makeSuccess("登陆成功")));
        out.flush();
        out.close();
    }
}
