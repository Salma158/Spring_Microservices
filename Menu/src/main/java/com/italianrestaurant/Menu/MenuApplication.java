package com.italianrestaurant.Menu;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@OpenAPIDefinition(
		info= @Info(
				title = "Menu microservice REST API microservice",
				description = "Italian restaurant menu microservice REST API microservice",
				version = "v1",
				contact = @Contact(
						name= "salma sherif",
						email = "salmasherif856@gmail.com"
				)

		)
)
public class MenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}

}
