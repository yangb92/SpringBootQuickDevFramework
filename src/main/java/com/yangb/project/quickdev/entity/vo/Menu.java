package com.yangb.project.quickdev.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * com.yangb.project.quickdev.entity.vo
 * Create by YangBin on 2020/11/29
 * Copyright © 2020 YangBin. All rights reserved.
 */
@Data
public class Menu implements Comparable<Menu> {
    private Integer id;
    private String name;
    private Integer parentId;
    private String url;
    private String icon;
    private Integer order;

    private List<Menu> children;


    @Override
    public int compareTo(Menu o) {
        return this.order - o.order;
    }
}
