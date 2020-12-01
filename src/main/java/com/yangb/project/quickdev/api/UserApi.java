package com.yangb.project.quickdev.api;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangb.project.quickdev.common.CommonDict;
import com.yangb.project.quickdev.common.ResultVo;
import com.yangb.project.quickdev.dao.AppUserMapper;
import com.yangb.project.quickdev.entity.AppUser;
import com.yangb.project.quickdev.entity.AppUserQo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * com.yangb.project.quickdev.api
 * Create by YangBin on 2020/11/30
 * Copyright © 2020 YangBin. All rights reserved.
 */
@RestController
@RequestMapping("/user")
public class UserApi {

    @Resource
    private AppUserMapper appUserMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @GetMapping("{id}")
    public ResultVo queryById(@PathVariable Integer id){
        AppUser user = appUserMapper.selectByPrimaryKey(id);
        return ResultVo.makeSuccess("用户信息", user);
    }

    @RequestMapping("/query")
    public ResultVo query(AppUserQo query){
        Example example = new Example(AppUser.class);
        if(StrUtil.isNotEmpty(query.getQuery())){
            example.createCriteria().andLike("username","%"+query.getQuery()+"%")
                    .orLike("fullname","%"+query.getQuery()+"%");
        }
        PageHelper.startPage(query.getPageNum(),query.getPageSize(),"id desc");
        List<AppUser> appUsers = appUserMapper.selectByExample(example);
        PageInfo<AppUser> pageInfo = new PageInfo<>(appUsers);
        return ResultVo.makeSuccess("用户列表",pageInfo);
    }

    @RequestMapping("/change")
    public ResultVo change(@RequestBody AppUser appUser){
        appUserMapper.updateByPrimaryKeySelective(appUser);
        return ResultVo.makeSuccess("用户信息修改成功");
    }

    @RequestMapping("/add")
    public ResultVo add(@RequestBody AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setCreateTime(new Date());
        appUser.setStatus(CommonDict.USER_STATUS_DISABLE);
        appUserMapper.insert(appUser);
        return ResultVo.makeSuccess("添加成功");
    }

    @RequestMapping("/del/{id}")
    public ResultVo del(@PathVariable Integer id){
        appUserMapper.deleteByPrimaryKey(id);
        return ResultVo.makeSuccess("删除成功!");
    }
}
