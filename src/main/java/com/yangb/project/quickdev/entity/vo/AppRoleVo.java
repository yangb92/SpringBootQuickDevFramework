package com.yangb.project.quickdev.entity.vo;

import com.yangb.project.quickdev.entity.AppRole;
import lombok.Data;

import java.util.List;

/**
 * com.yangb.project.quickdev.entity.vo
 * Create by YangBin on 2020/12/2
 * Copyright © 2020 YangBin. All rights reserved.
 */
@Data
public class AppRoleVo extends AppRole {

    private List<AppPermissionVo> permissions;
}
