package org.villalobos503developer.springproyectouniversidad.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("org.villalobos503developer")
                .packagesToScan("org.villalobos503developer.springproyectouniversidad.controller.dto")
                .build();
    }
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Universidad")
                        .description("Registros de universidad api rest ")
                        .version("v2")
                        .license(new License().name("Diego Villalobos").url(""))
                        .contact(new Contact()
                                .name("Diego Villalobos")
                                .email("diegovillalobos503@gmail.com.com")
                                )
                );
    }
}
