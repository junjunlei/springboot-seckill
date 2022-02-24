package com.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2021-12-18 11:37
 * @Version 1.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver);
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }
}
