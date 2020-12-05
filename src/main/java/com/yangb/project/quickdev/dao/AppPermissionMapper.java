package com.yangb.project.quickdev.dao;

import com.yangb.project.quickdev.entity.AppPermission;
import tk.mapper.Dao;

import java.util.List;

public interface AppPermissionMapper extends Dao<AppPermission> {

    List<AppPermission> queryByUserid(int userid);

    List<AppPermission> queryByRoleId(int roleid);

    List<AppPermission> queryUserMenu(int userid);
}