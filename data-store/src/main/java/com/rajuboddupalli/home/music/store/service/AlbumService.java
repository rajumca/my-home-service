package com.rajuboddupalli.home.music.store.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;
import com.rajuboddupalli.home.domain.entity.music.Album;
import com.rajuboddupalli.home.music.store.repository.MusicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService implements StorageService {
    @Autowired
    private MusicDAO musicDAO;
    private ObjectMapper objectMapper = new ObjectMapper();
    public void process(StoreObject storeObject) {

        musicDAO.insert(getAlbum(storeObject));
    }

    private Album getAlbum(StoreObject storeObject) {
        return objectMapper.convertValue(storeObject.getData(), Album.class);
    }

    @Override
    public StorageType getType() {
        return StorageType.ALBUM;
    }
}
