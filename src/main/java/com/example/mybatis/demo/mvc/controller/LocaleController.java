package com.example.mybatis.demo.mvc.controller;

import com.example.mybatis.demo.common.Util;
import com.example.mybatis.demo.common.helper.LocaleHelper;
import com.example.mybatis.demo.exception.PageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LocaleController {

    private static final Logger logger = LoggerFactory.getLogger(LocaleController.class);

    @Autowired
    private LocaleHelper localeHelper;

    @Autowired
    private LocaleResolver localeResolver;

    @GetMapping("/{countryCode}/locale")
    public String locale(@PathVariable String countryCode, HttpServletResponse response) {
        logger.debug("start locale");

        try {
            //set locale
            Locale locale = localeHelper.findLocale(countryCode);
            localeResolver.setLocale(Util.getRequest(), response, locale);

            //store locale in session
            Util.getSession().setAttribute("locale", locale);
            Util.getSession().setAttribute("countryCode", countryCode);

            return "locale/locale.simple";

        } catch(Exception e) {
            throw new PageException(e);
        }
    }

    @GetMapping("/other")
    public String other() {
        logger.debug("start other");

        try {
            return "locale/locale.simple";

        } catch(Exception e) {
            throw new PageException(e);
        }
    }
}
