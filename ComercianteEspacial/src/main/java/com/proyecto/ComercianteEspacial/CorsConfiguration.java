package com.proyecto.ComercianteEspacial;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Permite solicitudes solo desde este origen
                .allowedMethods("*") // Métodos HTTP permitidos
                .allowCredentials(true); // Permite incluir credenciales (cookies, encabezados) en la solicitud
    }
}
