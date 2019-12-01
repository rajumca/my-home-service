package com.rajuboddupalli.home.music.extract.receiver;

import com.rajuboddupalli.home.music.extract.extractor.AlbumExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExtractMessageReceiver {
    @Autowired
    private AlbumExtractor albumExtractor;

    @KafkaListener(topics = "MYHOME.TOPIC.MUSIC.EXTRACT", groupId = "myhome")
    public void receieveExtractMessage(String message) {
        albumExtractor.extract(message);
    }

}


