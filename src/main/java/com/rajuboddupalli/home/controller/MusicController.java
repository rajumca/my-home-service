package com.rajuboddupalli.home.controller;

import com.rajuboddupalli.home.model.Album;
import com.rajuboddupalli.home.process.MusicProcessor;
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

    @GetMapping
    public List<Album> getAlbums() throws IOException {
        return musicProcessor.getAlbums();
    }
}

