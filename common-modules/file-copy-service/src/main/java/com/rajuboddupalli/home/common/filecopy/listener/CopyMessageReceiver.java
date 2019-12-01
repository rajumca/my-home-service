package com.rajuboddupalli.home.common.filecopy.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.CopyObject;
import com.rajuboddupalli.home.common.filecopy.processor.CopyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

//import com.rajuboddupalli.home.common.constants.AudioConstants;
//import com.rajuboddupalli.home.music.extract.processor.CopyProcessor;

@Component
public class CopyMessageReceiver {
    @Autowired
    private CopyProcessor copyProcessor;

    @KafkaListener(topics = "MYHOME.TOPIC.FILE.COPY", groupId = "myhome")
    public void receieveCopyMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           CopyObject copyObject = objectMapper.readValue(message, CopyObject.class);
            copyProcessor.copy(copyObject);
        } catch (IOException e) {
            System.err.println("Error converting copy message: " + e.getMessage());
        }

    }
}


