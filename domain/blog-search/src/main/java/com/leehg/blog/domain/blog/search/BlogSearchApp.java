package com.leehg.blog.domain.blog.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.leehg.blog"})
public class BlogSearchApp {
    public static void main(String[] args) {
        SpringApplication.run(BlogSearchApp.class);
    }
}
