package com.yangb.project.quickdev.dao;

import com.yangb.project.quickdev.entity.AppRole;
import tk.mapper.Dao;

import java.util.List;

public interface AppRoleMapper extends Dao<AppRole> {

    List<AppRole> queryRoleByUserId(Integer userId);
}