package  com.register.configuration;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuracao do swagger
 * @author alan
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiConfigDocs() {
		  List<SecurityScheme> schemeList = new ArrayList<>();
	      schemeList.add(new ApiKey(org.springframework.http.HttpHeaders.AUTHORIZATION, "JWT", "header"));
		return new Docket(DocumentationType.SWAGGER_2)
				.produces(Collections.singleton("application/json"))
                .consumes(Collections.singleton("application/json"))
                .ignoredParameterTypes(Authentication.class)
                .securitySchemes(schemeList)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.register"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}
	
	 private static ApiKey apiKey() {
	        return new ApiKey("JWT", "Authorization", "header");
	 }
	 
	 private static SecurityContext securityContext() {
	        return SecurityContext.builder()
	        		.securityReferences(defaultAuth())
	        		.forPaths(PathSelectors.any())
	        		.build();
	 }
	 
	 private static List<SecurityReference> defaultAuth() {
	        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	        authorizationScopes[0] = authorizationScope;
	        return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
	 }
	
	 private static ApiInfo metaData() {
			return new ApiInfoBuilder()
			.title("Register - Servicos de Endereco")
			.description("\"Projeto - Street\"")
			.version("1.0.0")
			.build();
	}
	
}
