package com.mengfw.rms;

import com.mengfw.rms.filter.GlobalFilter;
import com.mengfw.rms.filter.XssFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by MFW on 2017/5/22.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.mengfw.rms.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
