package com.example.mybatis.demo.exception;

public class AsyncException extends RuntimeException {

    private String message;

    public AsyncException(String message) {
        this.message = message;
    }

    public AsyncException(Exception e) {
        this.message = e.getMessage();
    }
}
