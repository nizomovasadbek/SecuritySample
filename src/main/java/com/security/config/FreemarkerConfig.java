package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan("com.security")
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer free = new FreeMarkerConfigurer();
        free.setTemplateLoaderPath("/WEB-INF/views/");
        free.setDefaultEncoding("UTF-8");
        return free;
    }

    @Bean
    public ViewResolver getViewResolver(){
        FreeMarkerViewResolver res = new FreeMarkerViewResolver();
        res.setSuffix(".ftl");
        res.setContentType("text/html;charset=UTF-8");
        res.setCache(true);
        return res;
    }

}
