package com.example.mybatis.demo.exception;

public class AsyncException extends BaseException {

    public AsyncException(String message) {
        super(message);
    }

    public AsyncException(Exception e) {
        super(e);
    }
}
