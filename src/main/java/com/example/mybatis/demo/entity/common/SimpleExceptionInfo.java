package com.example.mybatis.demo.entity.common;

public class SimpleExceptionInfo {

    private boolean errorFlag = true;

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

    public boolean isErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(boolean errorFlag) {
        this.errorFlag = errorFlag;
    }
}
