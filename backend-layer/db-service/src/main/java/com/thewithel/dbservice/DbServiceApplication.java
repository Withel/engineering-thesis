package com.thewithel.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class DbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Database Service",
				"Simple service used to communicate with database.",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Matthew", "github.com/withel", "example@example.com"),
				"License",
				"example.com",
				Collections.emptyList()
		);
	}
}
