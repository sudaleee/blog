package com.application.blog.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = "com.blog")
public class BlogSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogSearchApplication.class);
    }
}
