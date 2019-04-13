package com.rajuboddupalli.home.music.extract.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.constants.AudioConstants;
import com.rajuboddupalli.home.music.extract.processor.CopyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class CopyMessageReceiver {
    @Autowired
    private CopyProcessor copyProcessor;

    @KafkaListener(topics = "MYHOME.MUSIC.COPY", groupId = "myhome")
    public void receieveCopyMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HashMap<String, String> hashMap = objectMapper.readValue(message, HashMap.class);
            copyProcessor.copy(hashMap.get(AudioConstants.FILE_NAME_KEY),hashMap.get(AudioConstants.TARGET_FOLDER_KEY));
        } catch (IOException e) {
            System.err.println("Error converting copy message: " + e.getMessage());
        }

    }
}


