package com.yangb.project.quickdev.config.comment;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.yangb.project.quickdev.dao.AppUserMapper;
import com.yangb.project.quickdev.entity.AppUser;
import com.yangb.project.quickdev.entity.bo.UserBo;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * com.yangb.project.quickdev.config.comment
 * Create by YangBin on 2020/11/27
 * Copyright © 2020 YangBin. All rights reserved.
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        /*
         * 拦截请求处理
         * 1. 获取请求头中的 Authorization 属性中的 jwt 加密字符串。
         * 2. 解密 jwt 获取用户信息
         * 3. 将解密的用户信息注册到认证管理器中
         * 4. 放行
         */
        final String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if(StrUtil.isEmpty(header) || !header.startsWith("Bearer ")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        final String token = header.split(" ")[1].trim();
        try {
            String json = JwtUtil.decoder(token);
            UserBo user = JSON.parseObject(json, UserBo.class);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUser(),null, AuthorityUtils.createAuthorityList(user.getPermission().stream().map(item -> item.getPermissionCode()).toArray(String[]::new)));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }catch (JwtException e){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }

    }
}
