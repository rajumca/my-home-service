package com.rajuboddupalli.home.music.extract.utils;

import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.entity.domain.Song;
import com.rajuboddupalli.home.music.extract.converter.PathConverter;
import com.rajuboddupalli.home.music.extract.converter.SongConverter;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SubDirectoryUtils {
    public List<Song> getList(Path directory, SongConverter pathConverter, Album album) throws IOException {
        List<Song> list = null;
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
           //  paths.forEach(path -> list.add(pathConverter.convert(path)));
            list = StreamSupport.stream(paths.spliterator(), true).map(path -> pathConverter.convert(path,album)).collect(Collectors.toList());
        }
        return list;
    }
}
