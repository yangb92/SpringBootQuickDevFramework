package com.yangb.project.quickdev.api;

import com.alibaba.fastjson.JSON;
import com.yangb.project.quickdev.common.ResultVo;
import com.yangb.project.quickdev.config.comment.JwtUtil;
import com.yangb.project.quickdev.dao.AppPermissionMapper;
import com.yangb.project.quickdev.entity.AppPermission;
import com.yangb.project.quickdev.entity.AppUser;
import com.yangb.project.quickdev.entity.bo.UserBo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * com.yangb.project.quickdev.api
 * Create by YangBin on 2020/11/28
 * Copyright © 2020 YangBin. All rights reserved.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthApi {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private AppPermissionMapper appPermissionMapper;

    @RequestMapping("/login")
    public ResultVo login(@RequestBody AppUser appUser){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
            AppUser user = (AppUser) authentication.getPrincipal();
            List<AppPermission> permissions = appPermissionMapper.queryByUserid(user.getId());
            UserBo ub = new UserBo();
            ub.setUser(user);
            ub.setPermission(permissions);
            ub.setToken("Bearer " + JwtUtil.encoder(JSON.toJSONString(ub)));
            return ResultVo.makeSuccess("200",ub);
        }catch (BadCredentialsException e){
            return ResultVo.makeFailed(400,e.getMessage());
        }
    }
}
