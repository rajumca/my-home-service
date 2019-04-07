package com.rajuboddupalli.home.music.utils;

import com.rajuboddupalli.home.music.converter.PathConverter;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SubDirectoryUtils<T> {
    public List<T> getList(Path directory, PathConverter<T> pathConverter) throws IOException {
        List<T> list = null;
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
           //  paths.forEach(path -> list.add(pathConverter.convert(path)));
            list = StreamSupport.stream(paths.spliterator(), true).map(path -> pathConverter.convert(path)).collect(Collectors.toList());
        }
        return list;
    }
}
