package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Demos9Application {
     @Bean
     public RestTemplate resttemplate() {
    	 return new RestTemplate();
     }
	public static void main(String[] args) {
		SpringApplication.run(Demos9Application.class, args);
	}

}
