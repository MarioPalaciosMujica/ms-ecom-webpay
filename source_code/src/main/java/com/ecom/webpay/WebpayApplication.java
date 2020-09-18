package com.ecom.webpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.transbank.webpay.configuration.Configuration;

@SpringBootApplication
public class WebpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebpayApplication.class, args);
	}

}
