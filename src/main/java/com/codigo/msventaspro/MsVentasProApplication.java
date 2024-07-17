package com.codigo.msventaspro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsVentasProApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVentasProApplication.class, args);
	}

}
