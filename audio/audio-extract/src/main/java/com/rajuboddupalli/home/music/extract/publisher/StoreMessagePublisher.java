package com.rajuboddupalli.home.music.extract.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;
import com.rajuboddupalli.home.domain.entity.music.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class StoreMessagePublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publish(Album album)  {
        StoreObject storeObject=new StoreObject(StorageType.ALBUM,album);
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        try {
            s = mapper.writeValueAsString(storeObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send("MYHOME.TOPIC.CASSANDRA.STORE", s);
    }
}
