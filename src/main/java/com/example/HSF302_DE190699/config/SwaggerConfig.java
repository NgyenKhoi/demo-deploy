package com.example.HSF302_DE190699.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Social Media API")
                        .version("1.0")
                        .description("API documentation for Social Media Project")
                        .contact(new Contact()
                                .name("Khôi")
                                .email("hehe    @example.com")
                        )
                );
    }
}

