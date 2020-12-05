package com.yangb.project.quickdev.api;

import com.yangb.project.quickdev.common.ResultVo;
import com.yangb.project.quickdev.dao.AppPermissionMapper;
import com.yangb.project.quickdev.entity.AppPermission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * com.yangb.project.quickdev.api
 * Create by YangBin on 2020/12/1
 * Copyright © 2020 YangBin. All rights reserved.
 */
@RestController
@RequestMapping("/permission")
public class PermissionApi {

    @Resource
    private AppPermissionMapper appPermissionMapper;

    @GetMapping
    public ResultVo list(){
        List<AppPermission> permissions = appPermissionMapper.selectAll();
        return ResultVo.makeSuccess("权限列表",permissions);
    }
}
