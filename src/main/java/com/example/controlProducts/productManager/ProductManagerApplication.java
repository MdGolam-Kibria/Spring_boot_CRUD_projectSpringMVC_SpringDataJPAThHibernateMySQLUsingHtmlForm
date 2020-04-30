package com.example.controlProducts.productManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProductManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductManagerApplication.class, args);
	}
//document for this project = https://www.codejava.net/frameworks/spring-boot/form-authentication-with-jdbc-and-mysql.
//role based access auth = https://www.youtube.com/watch?v=Dt0ZaeO3_y8&list=PLR2yPNIFMlL9UUF6-syrVrNaRwHVJofZE&index=21.
//main document for problem in spring security for some updates   = https://github.com/thymeleaf/thymeleaf-extras-springsecurity.
	//@Query annoation logic source https://youtu.be/oVKpNP3FcPc and https://thoughts-on-java.org/spring-data-jpa-query-annotation/
}
