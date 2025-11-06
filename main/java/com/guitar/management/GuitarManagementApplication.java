package com.guitar.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuitarManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuitarManagementApplication.class, args);
		System.out.println("✅ Ung dung Quan ly Guitar da khoi dong!");
	}
}
