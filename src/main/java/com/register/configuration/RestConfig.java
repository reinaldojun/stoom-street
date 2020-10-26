package com.register.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class RestConfig {
	/**
	 * Definimos o restTemplate
	 * 
	 * @return uma nova instancia do RestTemplate
	 */	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
