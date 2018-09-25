package com.example.mybatis.demo.common;

import com.example.mybatis.demo.entity.common.ExceptionInfo;

public class Util {

    public static ExceptionInfo getExceptionInfo(Exception e) {
        return new ExceptionInfo(e);
    }
}
