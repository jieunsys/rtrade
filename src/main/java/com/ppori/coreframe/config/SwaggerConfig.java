package com.ppori.coreframe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {
		Info info = new Info()
				.title("CODEFRAME 프레임워크 SwaggerDoc")
				.version(springdocVersion)
				.description("codeframe");
		
		return new OpenAPI()
				.components(new Components())
				.info(info);
	}
}
