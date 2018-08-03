package com.dz.user.payment.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class UserPaymentManagementApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(UserPaymentManagementApplication.class, args);
	}
}
