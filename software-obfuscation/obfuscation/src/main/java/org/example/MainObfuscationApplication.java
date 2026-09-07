package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainObfuscationApplication {

    public void calculateNumbers(int num1, int num2) {
        num1 += num2 * 10;
        num2 -= num1 / 2;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainObfuscationApplication.class, args);
        System.out.println("Application started.");
    }
}