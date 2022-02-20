package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("com.security")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    private ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext app){
        applicationContext = app;
    }

    @Bean
    public SpringResourceTemplateResolver temp(){
        SpringResourceTemplateResolver res = new SpringResourceTemplateResolver();
        res.setPrefix("/WEB-INF/views/");
        res.setSuffix(".html");
        res.setApplicationContext(applicationContext);
        return res;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(temp());
        engine.setEnableSpringELCompiler(true);
        return engine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver th = new ThymeleafViewResolver();
        th.setTemplateEngine(springTemplateEngine());
        registry.viewResolver(th);
    }
}
