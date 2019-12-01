package com.rajuboddupalli.home.music.store.service;

import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;

public interface  StorageService {
     void process(StoreObject storeObject);
     StorageType getType();
}
