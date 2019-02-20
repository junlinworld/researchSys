package com.example.sun.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@PropertySource(value = "cros.properties")
public class CrosConfiguration implements WebMvcConfigurer {

    @Value("${allowMapping}")
    private String allowMapping;

    @Value("${allowMethods}")
    private String allowMethosds;

    @Value("${allowCredentitials}")
    private boolean allowCredentitials;

    @Value("${allowOrigins}")
    private String allowOrigins;

    @Value("${allowHeaders}")
    private String allowHeaders;


    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping(allowMapping)
                .allowedOrigins(allowOrigins)
                .allowedMethods(allowMethosds)
                .allowedHeaders(allowHeaders)
                .allowCredentials(allowCredentitials);
    }
}
