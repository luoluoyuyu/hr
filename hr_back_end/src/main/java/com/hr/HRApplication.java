package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HRApplication {

    public static void main(String[] args) {
        SpringApplication.run(HRApplication.class, args);

    }
}
