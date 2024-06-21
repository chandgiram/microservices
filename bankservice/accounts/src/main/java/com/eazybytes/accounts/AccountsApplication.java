package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Account microservice Rest API Documentation",
		description = "Eazybank Account microservice Rest API Documentation",
		version = "v1",
		contact = @Contact(
			name = "Madan Reddy",
			email = "chandgirambaghel2001@gmail.com",
			url = "https://www.eazybytes.com"
		),
		license = @License(
				name = "Apache 2.0",
				url = "https://www.easybutes.com"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "EazyBack Account microservices REST API Documentation",
		url = "https://www.eazybytes.com/swagger-ui.html"
	)
)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
