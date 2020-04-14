package com.yangb.project.quickdev.service;

import com.yangb.project.quickdev.dao.AppPermissionMapper;
import com.yangb.project.quickdev.dao.AppUserMapper;
import com.yangb.project.quickdev.entity.AppPermission;
import com.yangb.project.quickdev.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangb on 2020/4/14
 */
//@Service
public class JdbcUserDetailService implements UserDetailsService {

    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private AppPermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserMapper.queryByUsername(username);
        if (user == null) {
            return null;
        }
        List<AppPermission> permissions = permissionMapper.queryByUserid(user.getId());
        UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword())
                .authorities(permissions.stream().map(item -> item.getCode()).toArray(String[]::new)).build();
        return userDetails;
    }
}
