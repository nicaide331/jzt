package com.example.jzt;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.jzt"})
public class JztApplication {
    public static void main(String[] args) {
        SpringApplication.run(JztApplication.class, args);
    }

}
