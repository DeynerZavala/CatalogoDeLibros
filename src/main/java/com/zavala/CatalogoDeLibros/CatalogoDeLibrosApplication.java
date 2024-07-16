package com.zavala.CatalogoDeLibros;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatalogoDeLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoDeLibrosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Aplicación iniciada correctamente.");
		};
	}
}

