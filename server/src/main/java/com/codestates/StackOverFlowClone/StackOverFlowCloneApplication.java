package com.codestates.StackOverFlowClone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class StackOverFlowCloneApplication   extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StackOverFlowCloneApplication.class, args);
	}

}
