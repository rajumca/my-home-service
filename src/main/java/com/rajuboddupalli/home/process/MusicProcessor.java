package com.rajuboddupalli.home.process;

import com.rajuboddupalli.home.function.AlbumConverter;
import com.rajuboddupalli.home.utils.SubDirectoryUtils;
import com.rajuboddupalli.home.model.Album;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class MusicProcessor {
    public List<Album> getAlbums() throws IOException {
        Path musicPath= Paths.get("G:\\MUSIC");
        List<Album> albums = new SubDirectoryUtils<Album>().getList(musicPath, new AlbumConverter());
        return albums;
    }


}
