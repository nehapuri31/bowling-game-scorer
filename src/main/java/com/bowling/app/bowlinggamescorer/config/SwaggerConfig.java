package com.bowling.app.bowlinggamescorer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

import static java.util.Collections.emptyList;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .displayRequestDuration(true)
                .validatorUrl("")
                .build();
    }

    @Bean
    public Docket bowlingScoreCalculationPerGame() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("bowling-game-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/v1/score-calculation/.*"))
                .build()
                .directModelSubstitute(LocalDate.class, String.class)
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Bowling Scorer API",
                "An API for calculating the score of each frame as per the pins down",
                "1.0",
                null,
                new Contact("Neha Puri", null, "neha.puri313@gmail.com"),
                null,
                null,
                emptyList());
    }

}
