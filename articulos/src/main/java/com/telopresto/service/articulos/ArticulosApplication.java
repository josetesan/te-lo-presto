package com.telopresto.service.articulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArticulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticulosApplication.class, args);
	}
}
