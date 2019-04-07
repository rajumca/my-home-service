package com.rajuboddupalli.home.music.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ExtractPublisher {
  @Autowired
  private KafkaTemplate<String,String> kafkaTemplate;

  @Autowired
  private KafkaTemplate<String,String> kafkaTemplate2;

    public void publish(String message){
      kafkaTemplate.send("MYHOME.MUSIC.EXTRACT", message);
    }
  public void publishTest(String message){
    kafkaTemplate2.send("test", message);
  }
}
