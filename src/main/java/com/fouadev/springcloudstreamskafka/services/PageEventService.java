package com.fouadev.springcloudstreamskafka.services;

import com.fouadev.springcloudstreamskafka.entities.PageEvent;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
 Created by : Fouad SAIDI on 12/02/2025
 @author : Fouad SAIDI
 @date : 12/02/2025
 @project : spring-cloud-streams-kafka
*/
@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("*****************");
            System.out.println(input.toString());
            System.out.println("*****************");
        };
    }
    // produire des messages aleatoires
    @Bean
    public Supplier<PageEvent> pageEventSupplier() {
        return () -> new PageEvent(Math.random() > 0.5 ? "P1" : "P2", Math.random() > 0.5 ? "user1" : "user2", new Date(), new Random().nextInt(9000));
    }
    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction(){
        return (input) -> {
            input.setName("L: "+input.getName().length());
            input.setUser("User");
            return input;
        };
    }
}