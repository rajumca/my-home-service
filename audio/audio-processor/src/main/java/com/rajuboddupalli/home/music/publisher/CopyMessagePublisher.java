package com.rajuboddupalli.home.music.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.constants.AudioConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CopyMessagePublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String filePath, String targetFolder) {
        Map<String, String> map = new HashMap<>();
        map.put(AudioConstants.FILE_NAME_KEY, filePath);
        map.put(AudioConstants.TARGET_FOLDER_KEY, targetFolder);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String message = objectMapper.writeValueAsString(map);
            kafkaTemplate.send("MYHOME.MUSIC.COPY", message);
        } catch (JsonProcessingException e) {
            System.err.println("Error converting copy message: "+e.getMessage());
        }

    }
}
