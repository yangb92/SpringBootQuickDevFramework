package com.yangb.project.quickdev.entity;

import com.github.pagehelper.Page;
import lombok.Data;

/**
 * com.yangb.project.quickdev.entity
 * Create by YangBin on 2020/11/30
 * Copyright © 2020 YangBin. All rights reserved.
 */
@Data
public class AppUserQo extends Page<Object> {
    private String query;
}
