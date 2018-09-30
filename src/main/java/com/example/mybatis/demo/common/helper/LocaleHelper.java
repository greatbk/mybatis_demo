package com.example.mybatis.demo.common.helper;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleHelper {

    public Locale findLocale(String countryCode) {
        if(countryCode == null) {
            return Locale.US;
        }

        switch(countryCode.toUpperCase()) {
            case "KR":
                return Locale.KOREA;
            case "US":
                return Locale.US;
            case "JP":
                return Locale.JAPAN;
            default:
                return Locale.US;
        }
    }
}
