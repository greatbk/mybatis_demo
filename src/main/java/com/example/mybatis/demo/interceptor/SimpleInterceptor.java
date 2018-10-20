package com.example.mybatis.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class SimpleInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SimpleInterceptor.class);

    private final String[] STATIC_RESOURCE_PATH = new String[]{"css", "js", "images"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.debug("EmployeesInterceptor:preHandle");
        logger.debug(request.getRequestURI());
        logger.debug(request.getContextPath());

        if(request.getRequestURI() == null) {
            return false;
        }

        String[] pathTokens = getPathTokens(request.getRequestURI(), request.getContextPath());
        if(pathTokens == null) {
            return false;
        }

        if(isStaticResource(pathTokens[0])) {
            logger.debug(String.format("skip static resource[%s]", request.getRequestURI()));
            return true;
        }

        //TODO add interceptor check logic..
        //If you throw a PageException, it will go to the error page

        return true;
    }

    private String[] getPathTokens(String uri, String contextPath) {
        uri = uri.replace(contextPath, "");
        if(uri.indexOf("/") == 0) {
            uri = uri.substring(1);
        }
        return uri.split("/");
    }

    private boolean isStaticResource(String firstPath) {
        if(Arrays.asList(STATIC_RESOURCE_PATH).contains(firstPath)) {
            return true;
        }
        return false;
    }
}
