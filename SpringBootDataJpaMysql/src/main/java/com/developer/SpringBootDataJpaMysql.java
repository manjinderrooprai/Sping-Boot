package com.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Manjinder.rooprai
 */
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootDataJpaMysql {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaMysql.class, args);
	}
}
