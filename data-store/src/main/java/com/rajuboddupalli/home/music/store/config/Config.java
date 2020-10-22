package com.rajuboddupalli.home.music.store.config;

import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.music.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class Config {

    @Autowired
    private List<StorageService> storageServiceList;
    @Bean
    public Map<StorageType, StorageService> storageServiceMap() {
        return storageServiceList.stream().collect(Collectors.toMap(StorageService::getType, Function.identity()));
    }
}
