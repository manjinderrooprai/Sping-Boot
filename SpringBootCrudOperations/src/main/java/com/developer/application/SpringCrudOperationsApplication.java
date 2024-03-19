package com.developer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Manjinder.rooprai
 */
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = { "com.developer.application" })
public class SpringCrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudOperationsApplication.class, args);
	}
}
