package com.vishwavijay.sample.springbootspringmvcspringsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//TODO this is not being used.. using theamleaf.... delete this file..

//@Configuration
//@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
    	
    	//registry.addResourceHandler("*").addResourceLocations(resourceLocations)
        //registry.addResourceHandler("/index.html").addResourceLocations("/index.html");
    }

}