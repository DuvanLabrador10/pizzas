package com.duvanlabrador.pizza.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //Se aplican todas las config a todas las rutas del server
                .allowedOrigins("*") //Desde todos los origenes
                .allowedHeaders("*") //Desde todos los headers
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE"); //Desde los siguientes Methods
    }
}
