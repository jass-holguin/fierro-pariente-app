package com.nearsoft.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FierroParienteApplication {

	@Value("${config.externalized.msg:No remote configuration found}")
	private String configMsg;

	public static void main(String[] args) {
		SpringApplication.run(FierroParienteApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> System.out.print(">>>>>> " + configMsg);
	}
}
