package com.rajuboddupalli.home.music.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExtractMessagePublisher {
  @Autowired
  private KafkaTemplate<String,String> kafkaTemplate;

    public void publish(String message){
      kafkaTemplate.send("MYHOME.MUSIC.EXTRACT", message);
    }
}
