package com.kb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by garlapati on 10/20/2016.
 */
@Configuration
public class SessionConfig extends WebMvcConfigurerAdapter {

    @Autowired
    SessionInterceptorAdapter sessionInterceptorAdapter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(sessionInterceptorAdapter);
    }
}
