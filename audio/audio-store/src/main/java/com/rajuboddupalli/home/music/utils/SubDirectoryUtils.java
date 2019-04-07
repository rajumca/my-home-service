package com.rajuboddupalli.home.music.utils;

import com.rajuboddupalli.home.music.converter.PathConverter;
import com.rajuboddupalli.home.music.converter.SongConverter;
import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.entity.domain.Song;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SubDirectoryUtils {
    public List getList(Album album, Path directory, SongConverter pathConverter) throws IOException {
        List<Song> list = null;
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
           //  paths.forEach(path -> list.add(pathConverter.convert(path)));
            list = StreamSupport.stream(paths.spliterator(), true).map(path -> pathConverter.convert(album, directory)).collect(Collectors.toList());
        }
        return list;
    }
}
