package com.yangb.project.quickdev.dao;

import com.yangb.project.quickdev.entity.AppUser;
import tk.mapper.Dao;

public interface AppUserMapper extends Dao<AppUser> {

    AppUser queryByUsername(String username);
}