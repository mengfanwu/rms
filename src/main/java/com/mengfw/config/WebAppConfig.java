package com.mengfw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by MFW on 2017/5/27.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Value("${app.staticPathPattern}")
    private String staticPathPattern;
    @Value("${app.staticPath}")
    private String staticPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticPathPattern).addResourceLocations(staticPath);
        super.addResourceHandlers(registry);
    }
}
