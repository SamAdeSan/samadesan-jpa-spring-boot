package org.ieselcaminas.jpa;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionJPA implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AplicacionJPA.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
