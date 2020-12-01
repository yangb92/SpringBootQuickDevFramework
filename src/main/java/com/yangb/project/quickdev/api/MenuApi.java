package com.yangb.project.quickdev.api;

import com.yangb.project.quickdev.common.ResultVo;
import com.yangb.project.quickdev.config.comment.CurrentUser;
import com.yangb.project.quickdev.dao.AppPermissionMapper;
import com.yangb.project.quickdev.entity.AppPermission;
import com.yangb.project.quickdev.entity.AppUser;
import com.yangb.project.quickdev.entity.vo.Menu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * com.yangb.project.quickdev.api
 * Create by YangBin on 2020/11/29
 * Copyright © 2020 YangBin. All rights reserved.
 */
@RestController
@RequestMapping("/api/menu")
public class MenuApi {

    private AppPermissionMapper appPermissionMapper;

    public MenuApi(AppPermissionMapper appPermissionMapper) {
        this.appPermissionMapper = appPermissionMapper;
    }

    @RequestMapping
    public ResultVo<List<Menu>> menuList(@CurrentUser AppUser user){
        List<AppPermission> permissions = appPermissionMapper.queryUserMenu(user.getId());
        List<Menu> menus = getMenus(0, permissions);
        return ResultVo.makeSuccess("菜单树", menus);
    }

    /**
     * 递归获取菜单树
     */
    private List<Menu> getMenus(Integer parentId, List<AppPermission> permissions){
        ArrayList<Menu> menus = new ArrayList<>();
        for (AppPermission permission : permissions) {
            if(parentId.equals(permission.getParentId())){
                Menu menu = permissionToMenu(permission);
                menu.setChildren(getMenus(menu.getId(),permissions)); //递归获取子节点
                menus.add(menu);
            }
        }
        return menus;
    }

    private Menu permissionToMenu(AppPermission permission){
        Menu menu = new Menu();
        menu.setId(permission.getId());
        menu.setParentId(permission.getParentId());
        menu.setIcon(permission.getIcon());
        menu.setName(permission.getName());
        menu.setOrder(permission.getOrder());
        menu.setUrl(permission.getUrl());
        return menu;
    }
}
