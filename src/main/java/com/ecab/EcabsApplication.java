package com.ecab;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@EnableRabbit
@ComponentScan(basePackages = "com.ecab")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class EcabsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(
				new Object[] { EcabsApplication.class }, args);
	}
}