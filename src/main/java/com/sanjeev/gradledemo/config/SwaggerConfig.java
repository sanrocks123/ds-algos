package com.sanjeev.gradledemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Cofig
 *
 * @author : Sanjeev Saxena
 * @Date : Jan 14, 2018
 * @since : 1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.sanjeev")).paths(PathSelectors.regex("/.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Tagging Service APIs", "Service to list all tagging related APIs", "1.0", "No Terms",
                "Sanjeev Saxena (sanrocks@gmail.com)", "", "");
    }
}