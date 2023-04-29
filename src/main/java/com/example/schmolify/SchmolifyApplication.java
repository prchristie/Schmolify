package com.example.schmolify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SchmolifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchmolifyApplication.class, args);
    }

    @PostMapping("/")
    public String hello(@RequestParam String url) {
        return "gday";
    }
}
