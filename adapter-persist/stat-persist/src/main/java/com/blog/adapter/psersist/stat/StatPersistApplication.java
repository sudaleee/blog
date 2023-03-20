package com.blog.adapter.psersist.stat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.blog.adapter.persist.cache")
public class StatPersistApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatPersistApplication.class);
    }
}
