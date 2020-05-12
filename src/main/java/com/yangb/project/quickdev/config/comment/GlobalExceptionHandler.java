package com.yangb.project.quickdev.config.comment;

import com.yangb.project.quickdev.common.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * Created by YangBin on 2020/5/11
 * Copyright (c) 2020 杨斌 All rights reserved.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultVo handleGlobalException(Exception e){
        e.printStackTrace();
        return ResultVo.makeFailed(HttpStatus.SEE_OTHER.value(), e.getMessage());
    }
}
