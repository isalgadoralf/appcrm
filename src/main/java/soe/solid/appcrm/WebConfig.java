package soe.solid.appcrm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {



    private String allowedOrigin = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("allowedOrigin: " + allowedOrigin);
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigin)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(false);
    }
}