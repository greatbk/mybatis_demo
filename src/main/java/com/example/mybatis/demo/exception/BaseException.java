package com.example.mybatis.demo.exception;

public class BaseException extends RuntimeException {

    protected String message;

    protected BaseException(String message) {
        this.message = message;
    }

    protected BaseException(Exception e) {
        this.message = e.getMessage();
    }
}
