package com.yangb.project.quickdev.config.comment;

import java.lang.annotation.*;

/**
 * 标记当前用户注解, 由MVC参数解析器注入
 * @author Created by yangb on 2020/4/14
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
