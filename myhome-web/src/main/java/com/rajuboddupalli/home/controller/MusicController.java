package com.rajuboddupalli.home.controller;

import com.rajuboddupalli.home.domain.entity.music.Album;
import com.rajuboddupalli.home.music.processor.MusicProcessor;
import com.rajuboddupalli.home.music.store.repository.MusicDAO;
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


    @GetMapping("extract")
    public void extract() throws IOException {
        musicProcessor.extract();
    }


    @GetMapping
    public List<Album> getAlbums() throws IOException {

        return musicProcessor.getAlbums();
    }
    @PostMapping("copy")
    public void copy(@RequestBody String filePath) throws IOException {
         musicProcessor.copy(filePath,"G:\\temp");
    }
    @GetMapping(value = "read",produces = "audio/mpeg")
    public List<String> getSOng(String path) throws IOException {
        return Files.readAllLines(Paths.get("G:\\MUSIC\\1 - Nenokkadine (2014) ~ 320 VBR\\01 - Who R U.mp3"), StandardCharsets.ISO_8859_1);
    }

}

