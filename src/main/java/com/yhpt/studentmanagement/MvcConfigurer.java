package com.yhpt.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: hjj
 * @Date: 2020/11/9 15:27
 * @Description:
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    @Autowired
    public MvcConfigurer(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/static/**").excludePathPatterns("/login").excludePathPatterns("/").excludePathPatterns("/loginValidate").addPathPatterns("/hjj/**");
    }

}
