package com.rajuboddupalli.home.music.extract.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.music.entity.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class StoreMessagePublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate2;

    public void publish(Album album)  {
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        try {
            s = mapper.writeValueAsString(album);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate2.send("MYHOME.MUSIC.STORE", s);
    }
}
