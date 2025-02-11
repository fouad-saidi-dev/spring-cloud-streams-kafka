package com.fouadev.springcloudstreamskafka.web;

import com.fouadev.springcloudstreamskafka.entities.PageEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

/*
 Created by : Fouad SAIDI on 11/02/2025
 @author : Fouad SAIDI
 @date : 11/02/2025
 @project : spring-cloud-streams-kafka
*/
@RestController
public class PageEventRestController {

    private StreamBridge streamBridge;

    public PageEventRestController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String topic, @PathVariable String name) {

        PageEvent pageEvent = new PageEvent(name, Math.random() > 0.5 ? "user1" : "user2", new Date(), new Random().nextInt(9000));

        streamBridge.send(topic, pageEvent);

        return pageEvent;
    }
}