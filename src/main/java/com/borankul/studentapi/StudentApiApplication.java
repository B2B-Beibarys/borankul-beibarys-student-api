package com.borankul.studentapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }

    @Bean
    CommandLineRunner startupMessage() {
        return args -> System.out.println(
            "Student API started. Author: Beibarys Borankul, group IT2-2306, student ID 38293");
    }
}
