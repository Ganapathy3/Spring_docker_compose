package com.demo.compose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Day 4 — Docker Compose: Spring Boot + PostgreSQL
 *
 * This app shows how two containers work together:
 *   Container 1: This Spring Boot app  (port 8080)
 *   Container 2: PostgreSQL database   (port 5432)
 *
 * Docker Compose wires them together automatically!
 */
@SpringBootApplication
public class DockerComposeDay4Application {
    public static void main(String[] args) {
        SpringApplication.run(DockerComposeDay4Application.class, args);
    }
}
