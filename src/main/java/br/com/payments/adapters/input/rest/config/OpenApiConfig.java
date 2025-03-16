package br.com.payments.adapters.input.rest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Payments Fake")
                .version("1.0.0")
                .description("")
                .contact(new Contact().name("Junior Morais").email("demoraisjunior@gmail.com")));
    }

}
