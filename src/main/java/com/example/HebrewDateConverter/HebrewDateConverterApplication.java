package com.example.HebrewDateConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

@SpringBootApplication
public class HebrewDateConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HebrewDateConverterApplication.class, args);
    }

}
