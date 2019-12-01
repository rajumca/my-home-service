package com.rajuboddupalli.home.photo.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;
import com.rajuboddupalli.home.common.logger.LoggingUtils;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ImagePublisher {

    private KafkaTemplate<String, String> kafkaTemplate;
    ObjectMapper objectMapper;

    private String topicName;

    public ImagePublisher(@Autowired KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
        this.topicName = "MYHOME.IMAGE.EXTRACT";
    }

//    @Value("${image.path.publishing.topic}")
//    private String topicName;

    public void publish(ImageAudit message){
        try {


           // audit(message, objectMapper);
            kafkaTemplate.send(topicName, objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            LoggingUtils.logError("",e);
        }
    }

    public void audit(ImageAudit message)  {

        String data = null;
        try {
            data = objectMapper.writeValueAsString(new StoreObject(StorageType.IMAGE_AUDIT, message));
        } catch (JsonProcessingException e) {
           LoggingUtils.logError("",e);
        }
        kafkaTemplate.send("MYHOME.TOPIC.CASSANDRA.STORE", data);
    }
}
