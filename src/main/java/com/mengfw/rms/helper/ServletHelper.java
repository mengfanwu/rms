package com.mengfw.rms.helper;

import com.google.common.base.Charsets;
import com.mengfw.rms.bean.GlobalResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MFW on 2017/5/29.
 */
public class ServletHelper {
    private static  final Logger LOGGER = LoggerFactory.getLogger(ServletHelper.class);
    private ServletHelper() {
    }

    public static HttpServletRequest getServletRequest() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if(attributes != null && attributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes)attributes).getRequest();
        } else {
            throw new RuntimeException("Servlet request is null.");
        }
    }

    public static HttpServletResponse getServletResponse() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if(attributes != null && attributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes)attributes).getResponse();
        } else {
            throw new RuntimeException("Servlet response is null.");
        }
    }

    public static String getRequestMethod() {
        HttpServletRequest request = getServletRequest();
        return request.getMethod();
    }

    public static boolean isPost() {
        try {
            return HttpMethod.POST.name().equals(getRequestMethod());
        } catch (RuntimeException var1) {
            LOGGER.warn(var1.getMessage(), var1);
            return false;
        }
    }

    public static void sendResponse(int statusCode, String message) {
        if(isPost()) {
            GlobalResult result = new GlobalResult();
            result.setLogin(GlobalContextHelper.getGlobalRequest().isLogin());
            result.setMessage(message);
            sendPostResponse(result);
        } else {
            sendGetResponse(statusCode, message);
        }

    }

    public static void sendPostResponse(GlobalResult result) {
        HttpServletResponse response = getServletResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding(Charsets.UTF_8.name());

        try {
            response.getOutputStream().write(result.toString().getBytes(Charsets.UTF_8));
        } catch (IOException var3) {
            LOGGER.error(var3.getMessage(), var3);
        }

    }

    public static void sendGetResponse(int statusCode, String message) {
        HttpServletResponse response = getServletResponse();

        try {
            response.sendError(statusCode, message);
        } catch (IOException var4) {
            LOGGER.error(var4.getMessage(), var4);
        }

    }
}
