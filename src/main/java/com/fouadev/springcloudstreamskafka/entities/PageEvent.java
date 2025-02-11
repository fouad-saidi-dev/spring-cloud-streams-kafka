package com.fouadev.springcloudstreamskafka.entities;
/*
 Created by : Fouad SAIDI on 11/02/2025
 @author : Fouad SAIDI
 @date : 11/02/2025
 @project : spring-cloud-streams-kafka
*/

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageEvent {
    private String name;
    private String user;
    private Date date;
    private long duration;
}