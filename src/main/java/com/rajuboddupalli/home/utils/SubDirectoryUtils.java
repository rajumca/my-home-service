package com.rajuboddupalli.home.utils;

import com.rajuboddupalli.home.function.PathConverter;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SubDirectoryUtils<T> {
    public List<T> getList(Path directory, PathConverter<T> pathConverter) throws IOException {
        List<T> list = new ArrayList<>();
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
            paths.forEach(path -> list.add(pathConverter.convert(path)));
        }
        return list;
    }
}
