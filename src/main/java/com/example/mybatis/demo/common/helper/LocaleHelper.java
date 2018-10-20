package com.example.mybatis.demo.common.helper;

import com.example.mybatis.demo.common.Util;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleHelper {

    public Locale findLocale(String countryCode) {
        if(countryCode == null) {
            return Locale.ENGLISH;
        }

        switch(countryCode.toUpperCase()) {
            case "KR":
                return Locale.KOREA;
            case "EN":
                return Locale.ENGLISH;
            default:
                return Locale.ENGLISH;
        }
    }

    public Locale getSessionLocale() {
        return (Locale)(Util.getSession().getAttribute("locale"));
    }
}
