package com.rajuboddupalli.home.music.extract.extractor;

import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.entity.domain.Song;
import com.rajuboddupalli.home.music.extract.converter.AlbumConverter;
import com.rajuboddupalli.home.music.repository.MusicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AlbumExtractor {
    @Autowired
    private MusicDAO musicDAO;

    public AtomicInteger counter = new AtomicInteger(0);

    public void extract(String path) {

        Album album = new AlbumConverter().convert(Paths.get(path));
        musicDAO.insert(album);
        System.out.println("Processed: " + counter.getAndIncrement());

    }
}
