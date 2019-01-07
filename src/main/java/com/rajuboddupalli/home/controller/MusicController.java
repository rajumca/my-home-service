package com.rajuboddupalli.home.controller;

import com.rajuboddupalli.home.entity.Album;
import com.rajuboddupalli.home.process.MusicProcessor;
import com.rajuboddupalli.home.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("albums")
public class MusicController {
    @Autowired
    private MusicProcessor musicProcessor;

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("insert")
    public List<Album> getAndInset() throws IOException {
        List<Album> albums = musicProcessor.getAlbums();
        albumRepository.insert(albums);
        return albums;
    }
    @GetMapping
    public List<Album> getAlbums() throws IOException {
        return albumRepository.findAll();
    }

}

