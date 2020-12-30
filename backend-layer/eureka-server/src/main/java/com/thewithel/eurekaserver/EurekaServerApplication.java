package com.thewithel.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableEurekaServer
@EnableSwagger2
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Service Discovery",
                "Eureka Server",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Matthew", "github.com/withel", "example@example.com"),
                "License",
                "example.com",
                Collections.emptyList()
        );
    }
}
