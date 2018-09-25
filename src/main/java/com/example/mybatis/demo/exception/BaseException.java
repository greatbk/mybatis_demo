package com.example.mybatis.demo.exception;

import com.example.mybatis.demo.entity.common.SimpleExceptionInfo;

public class BaseException extends RuntimeException {

    private String message;

    protected BaseException(String message) {
        this.message = message;
    }

    protected BaseException(Exception e) {
        this.message = e.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public SimpleExceptionInfo getSimpleExceptionInfo() {
        return new SimpleExceptionInfo(this);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
