package com.personal.example.pockafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PocKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocKafkaApplication.class, args);
	}

}
