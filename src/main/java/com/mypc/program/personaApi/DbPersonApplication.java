package com.mypc.program.personaApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com/mypc/program/personaApi/controller"})
public class DbPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbPersonApplication.class, args);
	}

}
