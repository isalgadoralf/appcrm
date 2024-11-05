package soe.solid.appcrm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {



    private String allowedOrigin = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("allowedOrigin: " + allowedOrigin);
        registry.addMapping("/**")
                .allowedOriginPatterns(allowedOrigin)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .maxAge(3600);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permite cualquier origen
        config.addAllowedOriginPattern("*");

        // Permite todos los métodos HTTP
        config.addAllowedMethod("*");

        // Permite todas las cabeceras
        config.addAllowedHeader("*");

        // Expone todas las cabeceras
        config.addExposedHeader("*");

        // Tiempo de cache para la respuesta preflight
        config.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}