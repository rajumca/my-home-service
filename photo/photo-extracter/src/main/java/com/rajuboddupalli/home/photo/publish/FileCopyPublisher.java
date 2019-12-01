package com.rajuboddupalli.home.photo.publish;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.CopyObject;
import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;
import com.rajuboddupalli.home.common.logger.LoggingUtils;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class FileCopyPublisher{

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    public void publish(CopyObject message) throws JsonProcessingException {


        String copyMessage = objectMapper.writeValueAsString(message);
        kafkaTemplate.send("MYHOME.TOPIC.FILE.COPY", copyMessage);
    }

    public void audit(ImageAudit message) {

        String data = null;
        try {
            data = objectMapper.writeValueAsString(new StoreObject(StorageType.IMAGE_AUDIT, message));
            kafkaTemplate.send("MYHOME.TOPIC.CASSANDRA.STORE", data);
        } catch (JsonProcessingException e) {
            LoggingUtils.logError("Error Auditing :"+message.getName(),e);
        }


    }
}
