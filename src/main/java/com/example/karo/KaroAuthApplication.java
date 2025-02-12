package com.example.karo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAsync
@RestController
@EnableAutoConfiguration
public class KaroAuthApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(KaroAuthApplication.class, args);
	}

}
