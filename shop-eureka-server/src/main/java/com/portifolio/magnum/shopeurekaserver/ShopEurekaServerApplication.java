package com.portifolio.magnum.shopeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ShopEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopEurekaServerApplication.class, args);
	}

}
