package com.yangb.project.quickdev.config.comment;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MVC参数时间格式转换
 * Created by YangBin on 2020/5/11
 * Copyright (c) 2020 杨斌 All rights reserved.
 */
@Component
public class DateConverter implements Converter<String, Date> {


    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String timeStampFormat = "^\\d $";

    @Override
    public Date convert(String value) {

        if(value == null || value.trim().equals("") || value.equalsIgnoreCase("null")) {
            return null;
        }

        value = value.trim();

        try {
            if (value.contains("-")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                return formatter.parse(value);
            } else if (value.matches(timeStampFormat)) {
                Long lDate = new Long(value);
                return new Date(lDate);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}