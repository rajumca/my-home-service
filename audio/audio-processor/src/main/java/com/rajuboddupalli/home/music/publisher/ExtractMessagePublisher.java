package com.rajuboddupalli.home.music.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ExtractMessagePublisher {
  @Autowired
  private KafkaTemplate<String,String> kafkaTemplate;

    public void publish(String message){
      kafkaTemplate.send("MYHOME.TOPIC.MUSIC.EXTRACT", message);
    }
}
