package com.greatlearning.ems.config;

import javax.sound.midi.MidiDevice.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig<GroupedOpenApi> {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("Employee-API").pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Employee Management API").description("Spring Employee Management application")
						.version("v0.0.1").license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("SpringShop Wiki Documentation")
						.url("https://springshop.wiki.github.org/docs"));
	}

}