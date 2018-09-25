package com.example.mybatis.demo.entity.common;

public class SimpleExceptionInfo {

    private String message;

    public SimpleExceptionInfo(RuntimeException e) {
        message = e.getMessage();
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(String.format("message: [%s]", message));
        return buf.toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
