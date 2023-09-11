package com.vti;


import com.vti.model.entity.Order;
import com.vti.model.request.CreateOrderRequest;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({"com.vti", "com.vti.configuration"})
@Configuration
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}


}








