package com.rajuboddupalli.home.music.extract.receiver;

import com.rajuboddupalli.home.music.extract.extractor.AlbumExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageReceiver {
    @Autowired
    private AlbumExtractor albumExtractor;

    @KafkaListener(topics = "test", groupId = "myhome")
    public void receieveMessage(String message) {
        albumExtractor.extract(message);
    }
}


