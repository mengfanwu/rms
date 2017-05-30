package com.mengfw;

import com.mengfw.filter.GlobalFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by MFW on 2017/5/22.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.mengfw.mapper")
public class Application {
    @Bean
    public FilterRegistrationBean globalFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new GlobalFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
