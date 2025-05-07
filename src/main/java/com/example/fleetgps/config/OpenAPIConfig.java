package com.example.fleetgps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;        // <-- model Info
import io.swagger.v3.oas.models.info.Contact;     // <-- model Contact


//http://localhost:8080/swagger-ui/index.html#/
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fleet GPS API")
                        .version("1.0")
                        .description("API documentation for the Fleet GPS application")
                        .contact(new Contact()
                                .name("Hans")
                                .email("hans@domain.com")
                        )
                );
    }
}
