package com.TCI.app.empresas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
@ComponentScan({"com.TCI.app.empresas.*"})
public class RestEmpresasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEmpresasApplication.class, args);
	}

}
