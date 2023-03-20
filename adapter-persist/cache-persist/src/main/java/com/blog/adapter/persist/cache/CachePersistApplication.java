package com.blog.adapter.persist.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = "com.blog.adapter.persist.cache")
public class CachePersistApplication {
    public static void main(String[] args) {
        SpringApplication.run(CachePersistApplication.class);
    }
}
