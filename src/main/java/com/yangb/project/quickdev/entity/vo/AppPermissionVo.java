package com.yangb.project.quickdev.entity.vo;

import com.yangb.project.quickdev.entity.AppPermission;
import lombok.Data;

import java.util.List;

/**
 * com.yangb.project.quickdev.entity.vo
 * Create by YangBin on 2020/12/2
 * Copyright © 2020 YangBin. All rights reserved.
 */
@Data
public class AppPermissionVo extends AppPermission {

    private List<AppPermissionVo> children;
}
