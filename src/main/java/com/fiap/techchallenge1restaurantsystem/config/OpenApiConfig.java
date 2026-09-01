package com.fiap.techchallenge1restaurantsystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI restaurantSystemOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Restaurant System API")
                        .description("Shared backend for multiple restaurants: user management, "
                                + "authentication and (in later phases) orders and reviews.")
                        .version("v1"));
    }
}
