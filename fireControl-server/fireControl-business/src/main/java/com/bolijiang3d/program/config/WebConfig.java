package com.bolijiang3d.program.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        if (enableSwagger){
            registry.addViewController("/login").setViewName("login");
            registry.addViewController("/index").setViewName("index");
        }

    }
}
