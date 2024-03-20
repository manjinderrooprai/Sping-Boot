package com.developer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;

/**
 * This class represents the open api config.
 * 
 * @author Manjinder.rooprai
 */
@RequiredArgsConstructor
@Configuration
public class OpenApiConfig {

        /**
         * Configure the open api bean with build property values.
         *
         * @return the configured open api config
         */
        @Bean
        public OpenAPI openApi() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("Spring boot curd operations")
                                                .version("1.0.0-SNAPSHOT")
                                                .description("This is a sample CRUD application using spring data")
                                                .contact(new Contact().name("Manjinder Rooprai")
                                                                .url("https://github.com/manjinderrooprai"))
                                                .license(new License()
                                                                .name("Apache 2.0")
                                                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
        }
}