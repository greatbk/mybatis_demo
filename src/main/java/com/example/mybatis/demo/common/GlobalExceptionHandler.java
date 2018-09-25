package com.example.mybatis.demo.common;

import com.example.mybatis.demo.entity.common.ExceptionInfo;
import com.example.mybatis.demo.exception.AsyncException;
import com.example.mybatis.demo.exception.PageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=PageException.class)
    public String pageExceptionHandler(PageException e, Model model) {
        model.addAttribute("info", Util.getExceptionInfo(e));
        return "error.simple";
    }

    @ExceptionHandler(value=AsyncException.class)
    @ResponseBody
    public ResponseEntity<ExceptionInfo> asyncExceptionHandler(AsyncException e) {
        return new ResponseEntity<>(Util.getExceptionInfo(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
