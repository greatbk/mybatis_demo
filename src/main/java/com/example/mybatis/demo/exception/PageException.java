package com.example.mybatis.demo.exception;

public class PageException extends RuntimeException {

    private String message;

    public PageException(String message) {
        this.message = message;
    }

    public PageException(Exception e) {
        this.message = e.getMessage();
    }
}
