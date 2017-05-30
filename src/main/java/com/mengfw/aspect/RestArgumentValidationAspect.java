package com.mengfw.aspect;

import com.mengfw.helper.ServletHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by MFW on 2017/5/30.
 */
//@Aspect
//@Order(1)
//@Configuration
public class RestArgumentValidationAspect {
    private static  final Logger LOGGER = LoggerFactory.getLogger(RestArgumentValidationAspect.class);
    @Pointcut("execution(* com.mengfw.controller..*.*(..))")
    public void executeService(){

    }

    @Around("executeService()")
    public Object filter(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult bindingResult = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg != null && arg instanceof BindingResult) {
                bindingResult = (BindingResult) arg;
                break;
            }
        }
        if (bindingResult != null && bindingResult.hasErrors()) {
            ServletHelper.sendResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    generateErrorMessages(bindingResult.getAllErrors()));
            return null;
        }
        return joinPoint.proceed();
    }

    private String generateErrorMessages(List<ObjectError> errors) {
        StringBuilder builder = new StringBuilder();
        errors.forEach(e -> builder.append(e.getDefaultMessage()).append("|"));
        return builder.toString();
    }
}
