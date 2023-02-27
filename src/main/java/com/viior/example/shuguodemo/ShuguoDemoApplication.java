package com.viior.example.shuguodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class ShuguoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShuguoDemoApplication.class, args);
    }

}
