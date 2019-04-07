package com.rajuboddupalli.home.music.converter;

import java.nio.file.Path;

@FunctionalInterface
public interface PathConverter<T> {
    public T convert(Path path);
}

