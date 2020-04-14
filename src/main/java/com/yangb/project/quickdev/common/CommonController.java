package com.yangb.project.quickdev.common;

import com.yangb.project.quickdev.entity.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Created by yangb on 2020/4/14
 */
public class CommonController {

    /**
     * 获取登陆用户
     * @return
     */
    public AppUser getUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof AppUser){
            return (AppUser) principal;
        }
        return null;
    }
}
