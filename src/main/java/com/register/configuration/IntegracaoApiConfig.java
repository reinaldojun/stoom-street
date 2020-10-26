package com.register.configuration;

import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import lombok.Data;

@Configuration
@ConfigurationProperties("uri.acess")
@Data
@Primary
public class IntegracaoApiConfig {

	// SERVIDOR
	private String geolocalizacao;
	
	public String uri(String contexto, String parametros) {
		return contexto + parametros;
	}

	public String montarParametros(Map<String, String> mapParametos, HttpServletRequest request) {
		String parametros = mapParametos.entrySet().stream()
				.filter(x -> request.getHeader(x.getKey()) != null || request.getAttribute(x.getKey()) != null)
				.map(x -> request.getHeader(x.getKey()) != null ? (x.getKey() + "=" + request.getHeader(x.getKey()))
						: (x.getKey() + "=" + request.getAttribute(x.getKey())))
				.collect(Collectors.joining("&", "?", ""));
		return parametros;
	}
	

    
}
