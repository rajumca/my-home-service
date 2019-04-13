package com.rajuboddupalli.home.music.extract.extractor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.extract.converter.AlbumConverter;
import com.rajuboddupalli.home.music.extract.publisher.StoreMessagePublisher;
import com.rajuboddupalli.home.music.store.repository.MusicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AlbumExtractor {
    @Autowired
    private MusicDAO musicDAO;

    @Autowired
    private StoreMessagePublisher storeMessagePublisher;

    public AtomicInteger counter = new AtomicInteger(0);

    public void extract(String path) {

        Album album = new AlbumConverter().convert(Paths.get(path));
        storeMessagePublisher.publish(album);
        System.out.print("Processed: " + counter.getAndIncrement()+ ":"+LocalDateTime.now()+",");


    }
}
