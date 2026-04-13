package com.livestock.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI livestockOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Livestock AI API")
                        .description("API de gerenciamento de animais")
                        .version("1.0.0"));
    }
}