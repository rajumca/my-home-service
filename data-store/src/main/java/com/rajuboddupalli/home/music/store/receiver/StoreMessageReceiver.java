package com.rajuboddupalli.home.music.store.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;
import com.rajuboddupalli.home.common.logger.LoggingUtils;
import com.rajuboddupalli.home.music.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class StoreMessageReceiver {

    @Autowired
   private Map<StorageType,StorageService> storageServiceMap;

    @KafkaListener(topics = "MYHOME.TOPIC.CASSANDRA.STORE", groupId = "myhomeStore")
    public void receiveMessage(String string) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        StoreObject storeObject = mapper.readValue(string, StoreObject.class);
        storageServiceMap.get(storeObject.getType()).process(storeObject);
    }
}
