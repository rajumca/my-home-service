package com.rajuboddupalli.home.common.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.logger.LoggingUtils;
import org.springframework.stereotype.Component;

@Component
public class JsonParser<T> {
    private ObjectMapper objectMapper=new ObjectMapper();

    public String conevertToString(T t){
        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            LoggingUtils.logError("Error Parsing",e);
            return null;
        }
    }

}
