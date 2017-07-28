package com.mengfw.rms.config;

import com.mengfw.rms.filter.GlobalFilter;
import com.mengfw.rms.filter.XssFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mengfw on 2017/7/28.
 */
@Configuration
public class FilterConfig {
    @Autowired
    private XssFilter xssFilter;
    @Bean
    public FilterRegistrationBean globalFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new GlobalFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(xssFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
