package com.example.karo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KaroApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(KaroApplication.class, args);
	}

}
