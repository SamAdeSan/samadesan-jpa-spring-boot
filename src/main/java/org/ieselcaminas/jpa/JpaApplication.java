package org.ieselcaminas.jpa;

import org.ieselcaminas.jpa.entity.Planeta;
import org.ieselcaminas.jpa.entity.Satelite;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	//En este método definimos nuestro propio código
	@Override
	public void run(String... args) {
		Satelite satelite = new Satelite("Luna", "Apollo 1");
		Planeta planeta = new Planeta(3, "Tierra", "Tiene un 70% de agua (No soy planeta, soy redondeta (según terraplanistas))", satelite);

		System.out.println(planeta);
	}
}
