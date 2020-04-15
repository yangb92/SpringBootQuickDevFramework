package com.yangb.project.quickdev.config.comment;

import com.yangb.project.quickdev.dao.AppPermissionMapper;
import com.yangb.project.quickdev.dao.AppUserMapper;
import com.yangb.project.quickdev.entity.AppPermission;
import com.yangb.project.quickdev.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义认证
 * @author Created by yangb on 2020/4/14
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private AppPermissionMapper permissionMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        AppUser user = appUserMapper.queryByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户未找到");
        }
        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new BadCredentialsException("密码错误");
        }
        List<AppPermission> permissions = permissionMapper.queryByUserid(user.getId());

        return new UsernamePasswordAuthenticationToken(user,password,
                AuthorityUtils.createAuthorityList(permissions.stream().map(item -> item.getCode()).toArray(String[]::new)));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
