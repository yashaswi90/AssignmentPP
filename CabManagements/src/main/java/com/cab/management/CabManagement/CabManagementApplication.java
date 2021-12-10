package com.cab.management.CabManagement;

import com.cab.management.CabManagement.services.CabRegistrationPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
public class CabManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabManagementApplication.class, args);
	}

}
