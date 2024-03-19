package com.hackathon.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EntityScan
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "HACKATHON - GRUPO 11 ", version = "1",description = "API Reserva Hotel"))
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

}
