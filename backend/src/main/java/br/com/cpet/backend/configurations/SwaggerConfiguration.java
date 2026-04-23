package br.com.cpet.backend.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    OpenAPI cafeAromaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Café Aroma API")
                        .description("Sistema de gestão para cafeteria: catálogo de produtos, categorias, banners e suporte ao cliente.")
                        .version("v1.0.0")
                        .contact(new Contact().name("Equipe de Desenvolvimento").email("dev@cafearoma.com.br")));
    }
}