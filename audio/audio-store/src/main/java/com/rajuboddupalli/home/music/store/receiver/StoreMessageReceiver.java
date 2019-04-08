package com.rajuboddupalli.home.music.store.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.store.repository.MusicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StoreMessageReceiver {
    @Autowired
    private MusicDAO musicDAO;

    @KafkaListener(topics = "MYHOME.MUSIC.STORE", groupId = "myhomeStore")
    public void receiveMessage(String string) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Album album = mapper.readValue(string, Album.class);
        musicDAO.insert(album);
    }
}
