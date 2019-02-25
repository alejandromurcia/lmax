package com.uniandes.lmax.utils;

import com.uniandes.lmax.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticContextInitializer {

    @Autowired
    private Sender sender;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        KafkaUtils.setSender(sender);
    }
}