package com.example.demo.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/Main").setViewName("Main");
        registry.addViewController("/").setViewName("Main");
        registry.addViewController("/UserPage").setViewName("UserPage");
        registry.addViewController("/Login").setViewName("Login");
    }

}