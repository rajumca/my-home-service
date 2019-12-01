package com.rajuboddupalli.home.music.store.service;

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

    public void process(StoreObject storeObject) {
        musicDAO.insert((Album) storeObject.getData());
    }

    @Override
    public StorageType getType() {
        return StorageType.ALBUM;
    }
}
