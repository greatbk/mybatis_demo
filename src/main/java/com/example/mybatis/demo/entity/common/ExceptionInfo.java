package com.example.mybatis.demo.entity.common;

public class ExceptionInfo {

    private String message;

    /**
     * 생성자
     * @param e 오류
     */
    public ExceptionInfo(Exception e) {
        message = e.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
