package com.rajuboddupalli.home.music.publisher;

import com.rajuboddupalli.home.common.domain.CopyObject;
import com.rajuboddupalli.home.common.domain.CopyObjectType;
import com.rajuboddupalli.home.common.parser.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CopyMessagePublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private JsonParser jsonParser;

    public void publish(String filePath, String targetFolder) {

        CopyObject copyObject = new CopyObject(filePath, targetFolder, false, false, CopyObjectType.MUSIC,null);
        Optional<String> message = Optional.ofNullable(jsonParser.conevertToString(copyObject));
        message.ifPresent(m -> kafkaTemplate.send("MYHOME.MUSIC.COPY", m));

    }
}
