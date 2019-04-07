package com.rajuboddupalli.home.music.extract.converter;

import java.nio.file.Path;

@FunctionalInterface
public interface PathConverter<T,S> {
    public T convert(Path path,S additionalInfo);
}

