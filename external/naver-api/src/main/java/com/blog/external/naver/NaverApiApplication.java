package com.blog.external.naver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.blog.external.naver")
public class NaverApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(NaverApiApplication.class);
    }
}
