package br.com.fit.petsFilterHistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PetsFilterHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsFilterHistoryApplication.class, args);
	}

}
