package com.yangb.project.quickdev;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangb.project.quickdev.dao.AppPermissionMapper;
import com.yangb.project.quickdev.dao.AppUserMapper;
import com.yangb.project.quickdev.entity.AppPermission;
import com.yangb.project.quickdev.entity.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@SpringBootTest(classes = QuickDevApplication.class)
class QuickDevApplicationTests {

    @Autowired
    AppUserMapper appUserMapper;

    @Autowired
    AppPermissionMapper permissionMapper;

    @Test
    void testQueryByUsername() {
        PageHelper.startPage(1, 10);
        Example example = new Example(AppUser.class);
        example.createCriteria().andEqualTo("username","lisi");
        PageInfo<AppUser> pageInfo = new PageInfo<>(appUserMapper.selectByExample(example));

        AppUser user = appUserMapper.queryByUsername("yb");
        System.out.println(user.getFullname());
    }

    @Test
    void testQueryByUserid() {
        List<AppPermission> list = permissionMapper.queryByUserid(1);
        list.forEach(item -> System.out.println(item.getPermissionCode()));
    }
}
