package com.example.springbootAWS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Lee Su Jeong
 * @date 2023/05/22
 */
@SpringBootApplication
@EnableAsync
@EnableJpaAuditing // JPA Auditing 활성화
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


