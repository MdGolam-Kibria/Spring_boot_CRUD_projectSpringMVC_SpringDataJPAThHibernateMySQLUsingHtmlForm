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

}
