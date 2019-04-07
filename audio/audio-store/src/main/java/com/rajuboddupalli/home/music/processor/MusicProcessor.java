package com.rajuboddupalli.home.music.processor;

import com.rajuboddupalli.home.music.converter.AlbumConverter;
import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.utils.SubDirectoryUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Component
public class MusicProcessor {




    public void copy(String path) throws IOException {
        System.out.println(LocalDateTime.now());
        Files.copy(Paths.get("G:\\MUSIC\\1 - Nenokkadine (2014) ~ 320 VBR\\01 - Who R U.mp3"),Paths.get("G:\\temp\\01 - Who R U.mp3"),REPLACE_EXISTING);     System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
    }


}
