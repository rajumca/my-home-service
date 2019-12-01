package com.rajuboddupalli.home.common.filecopy.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.CopyObject;
import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ImageStoreMessagePublisher {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();


    public void audit(ImageAudit message)  {

        String data = null;
        try {
            data = objectMapper.writeValueAsString(new StoreObject(StorageType.IMAGE_AUDIT, message));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send("MYHOME.TOPIC.CASSANDRA.STORE", data);

    }
}
