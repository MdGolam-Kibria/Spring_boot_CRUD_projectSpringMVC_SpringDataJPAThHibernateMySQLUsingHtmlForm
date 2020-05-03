package com.example.controlProducts.productManager.springSecurity.accessPageControlWithSpringSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AllViewController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/login_error").setViewName("login_error");// spring security login filure url handle here
        registry.addViewController("/againLogIn").setViewName("login");
    }
}
