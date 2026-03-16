package com.myshop.productcatalog;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI productCatalogOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Catalog API")
                        .description("My first Spring Boot API")
                        .version("1.0"));
    }
}