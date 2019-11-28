package com.portifolio.magnum.eventregisterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EventRegisterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventRegisterApiApplication.class, args);
	}

}
