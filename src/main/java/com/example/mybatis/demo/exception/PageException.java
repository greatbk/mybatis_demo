package com.example.mybatis.demo.exception;

public class PageException extends BaseException {

    public PageException(String message) {
        super(message);
    }

    public PageException(Exception e) {
        super(e);
    }
}
