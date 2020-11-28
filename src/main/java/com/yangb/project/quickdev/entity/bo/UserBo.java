package com.yangb.project.quickdev.entity.bo;

import com.yangb.project.quickdev.entity.AppPermission;
import com.yangb.project.quickdev.entity.AppUser;
import lombok.Data;

import java.util.List;

/**
 * com.yangb.project.quickdev.entity.bo
 * Create by YangBin on 2020/11/28
 * Copyright © 2020 YangBin. All rights reserved.
 */
@Data
public class UserBo {
    private AppUser user;
    private List<AppPermission> permission;
    private String token;
}
