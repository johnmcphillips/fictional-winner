package com.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Testing", version = "1.0", description = "Swagger UI for testing APIs"))



public class swagapp {
    public static void main(String[] args) {
        SpringApplication.run(swagapp.class, args);
    }
}