package com.uniandes.lmax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(
        "com.uniandes.lmax.*"
)
@EnableAutoConfiguration
@EnableAsync
public class LmaxApplication{
    public static void main(final String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LmaxApplication.class, args);
    }
}


