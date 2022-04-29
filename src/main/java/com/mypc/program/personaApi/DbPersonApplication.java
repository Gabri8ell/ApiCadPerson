package com.mypc.program.personaApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com/mypc/program/personaApi/controller"})
public class DbPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbPersonaApplication.class, args);
	}

}
