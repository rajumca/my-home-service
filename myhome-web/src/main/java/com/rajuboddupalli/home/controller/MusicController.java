package com.rajuboddupalli.home.controller;

import com.rajuboddupalli.home.music.entity.Album;
import com.rajuboddupalli.home.music.repository.MusicDAO;
import com.rajuboddupalli.home.music.processor.MusicProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("albums")
public class MusicController {

    @Autowired
    private MusicDAO musicDAO;

    @Autowired
    private MusicProcessor musicProcessor;

    @GetMapping("insert")
    public List<Album> getAndInset() throws IOException {
        return musicDAO.insert();
    }

    @GetMapping
    public List<Album> getAlbums() throws IOException {
        return musicDAO.findAll();
    }
    @GetMapping("copy")
    public void copy() throws IOException {
         musicProcessor.copy("");
    }
    @GetMapping(value = "read",produces = "audio/mpeg")
    public List<String> getSOng(String path) throws IOException {
        return Files.readAllLines(Paths.get("G:\\MUSIC\\1 - Nenokkadine (2014) ~ 320 VBR\\01 - Who R U.mp3"), StandardCharsets.ISO_8859_1);
    }

}

