package com.ecab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class EcabsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(
				new Object[] { EcabsApplication.class }, args);
	}
}