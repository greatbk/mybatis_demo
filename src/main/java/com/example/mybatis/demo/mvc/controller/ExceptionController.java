package com.example.mybatis.demo.mvc.controller;

import com.example.mybatis.demo.exception.AsyncException;
import com.example.mybatis.demo.exception.PageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    /**
     *
     * @return
     */
    @GetMapping("/pageException")
    public String pageException() {
        logger.debug("start pageException");
        throw new PageException("page exception example");
    }

    /**
     *
     * @return
     */
    @GetMapping("/asyncException")
    @ResponseBody
    public Object asyncException() {
        logger.debug("start pageException");
        throw new AsyncException("async exception example");
    }
}
