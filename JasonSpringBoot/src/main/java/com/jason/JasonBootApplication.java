package com.jason;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.jason.dao",
                               "com.jason.daosupport",
                               "com.jason.service",
                               "com.jason.control"})
public class JasonBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasonBootApplication.class, args);
    }

}
