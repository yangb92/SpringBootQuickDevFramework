package com.yangb.project.quickdev.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.yangb.project.quickdev.common.ResultVo;
import com.yangb.project.quickdev.dao.AppPermissionMapper;
import com.yangb.project.quickdev.dao.AppRoleMapper;
import com.yangb.project.quickdev.dao.AppRolePermissionMapper;
import com.yangb.project.quickdev.dao.AppUserRoleMapper;
import com.yangb.project.quickdev.entity.AppPermission;
import com.yangb.project.quickdev.entity.AppRole;
import com.yangb.project.quickdev.entity.AppRolePermission;
import com.yangb.project.quickdev.entity.AppUserRole;
import com.yangb.project.quickdev.entity.vo.AppPermissionVo;
import com.yangb.project.quickdev.entity.vo.AppRoleVo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by YangBin on 2020/12/1
 * Copyright © 2020 YangBin. All rights reserved.
 */
@RestController
@RequestMapping("/role")
public class RoleApi {

    @Resource
    private AppRoleMapper roleMapper;
    @Resource
    private AppPermissionMapper permissionMapper;
    @Resource
    private AppRolePermissionMapper rolePermissionMapper;
    @Resource
    private AppUserRoleMapper userRoleMapper;

    @GetMapping
    public ResultVo list() {
        List<AppRole> appRoles = roleMapper.selectAll();
        List<AppRoleVo> roleVos = appRoles.stream().map(role -> {
            AppRoleVo roleVo = new AppRoleVo();
            BeanUtil.copyProperties(role, roleVo);
            List<AppPermission> permissions = queryRolePermission(role.getId());
            if (permissions == null) return roleVo;
            List<AppPermissionVo> permissionVos = permissions.stream().map(permission -> {
                AppPermissionVo appPermissionVo = new AppPermissionVo();
                BeanUtil.copyProperties(permission, appPermissionVo);
                return appPermissionVo;
            }).collect(Collectors.toList());
            roleVo.setPermissions(structAppPermission(0, permissionVos));
            return roleVo;
        }).collect(Collectors.toList());
        return ResultVo.makeSuccess("角色信息", roleVos);
    }

    @RequestMapping("/permission/tree")
    public ResultVo getPermissionTree() {
        List<AppPermission> permissions = permissionMapper.selectAll();
        List<AppPermissionVo> permissionVos = permissions.stream().map(permission -> {
            AppPermissionVo appPermissionVo = new AppPermissionVo();
            BeanUtil.copyProperties(permission, appPermissionVo);
            return appPermissionVo;
        }).collect(Collectors.toList());
        List<AppPermissionVo> appPermissionVos = structAppPermission(0, permissionVos);
        return ResultVo.makeSuccess("查询成功", appPermissionVos);
    }

    private List<AppPermissionVo> structAppPermission(Integer parentId, List<AppPermissionVo> vos) {
        ArrayList<AppPermissionVo> appPermissionVos = new ArrayList<>();
        for (AppPermissionVo vo : vos) {
            if (parentId.equals(vo.getParentId())) {
                vo.setChildren(structAppPermission(vo.getId(), vos));
                appPermissionVos.add(vo);
            }
        }
        return appPermissionVos;
    }

    @GetMapping("{id}")
    public ResultVo one(@PathVariable Integer id) {
        AppRole appRole = roleMapper.selectByPrimaryKey(id);
        return ResultVo.makeSuccess("角色查询成功", appRole);
    }

    @PutMapping
    public ResultVo put(@RequestBody AppRole appRole) {
        if (appRole.getId() != null) {
            roleMapper.updateByPrimaryKeySelective(appRole);
        } else {
            roleMapper.insert(appRole);
        }
        return ResultVo.makeSuccess("添加成功");
    }

    @DeleteMapping("{id}")
    public ResultVo del(@PathVariable Integer id) {
        roleMapper.deleteByPrimaryKey(id);
        return ResultVo.makeSuccess("删除成功!");
    }

    List<AppPermission> queryRolePermission(Integer roleId) {
        return permissionMapper.queryByRoleId(roleId);
    }

    @PostMapping("/permission/delete")
    public ResultVo delRolePermission(Integer roleId, String permissionIds) {
        Example example = new Example(AppRolePermission.class);
        example.createCriteria().andEqualTo("roleId", roleId).andIn("permissionId", Arrays.asList(permissionIds.split(",")));
        rolePermissionMapper.deleteByExample(example);
        List<AppPermission> permissions = queryRolePermission(roleId);
        List<AppPermissionVo> permissionVos = permissions.stream().map(permission -> {
            AppPermissionVo appPermissionVo = new AppPermissionVo();
            BeanUtil.copyProperties(permission, appPermissionVo);
            return appPermissionVo;
        }).collect(Collectors.toList());
        List<AppPermissionVo> appPermissionVos = structAppPermission(0, permissionVos);
        return ResultVo.makeSuccess("删除成功!", appPermissionVos);
    }

    @PostMapping("/permission/add")
    public ResultVo addRolePermissions(Integer roleId, String permissions) {
        if (StrUtil.isEmpty(permissions))
            return ResultVo.makeFailed("permissions 不能是空");
        // 删除该角色旧权限
        Example example = new Example(AppRolePermission.class);
        example.createCriteria().andEqualTo("roleId", roleId);
        rolePermissionMapper.deleteByExample(example);
        // 插入新权限
        AppRolePermission appRolePermission = new AppRolePermission();
        appRolePermission.setRoleId(roleId);
        for (String permissionId : permissions.split(",")) {
            appRolePermission.setPermissionId(Integer.valueOf(permissionId));
            rolePermissionMapper.insert(appRolePermission);
        }
        return ResultVo.makeSuccess("添加成功");
    }

    /**
     * 为用户添加角色
     */
    @RequestMapping("/user")
    public ResultVo addUserRole(Integer userId, String roleIds){
        if(userId == null || StrUtil.isEmpty(roleIds)){
            return ResultVo.makeFailed("参数不能为空");
        }
        // 删除旧的角色
        Example example = new Example(AppUserRole.class);
        example.createCriteria().andEqualTo("userId",userId);
        userRoleMapper.deleteByExample(example);
        // 添加新角色
        AppUserRole appUserRole = new AppUserRole();
        appUserRole.setUserId(userId);
        for (String roleId : roleIds.split(",")) {
            appUserRole.setRoleId(Integer.valueOf(roleId));
            userRoleMapper.insert(appUserRole);
        }
        return ResultVo.makeSuccess("添加成功");
    }

    /**
     * 查询用户角色信息
     */
    @RequestMapping("/user/detail")
    public ResultVo queryUserRoleInfo(Integer userId){
        List<AppRole> appRoles = roleMapper.queryRoleByUserId(userId);
        return ResultVo.makeSuccess("查询成功",appRoles);
    }
}
