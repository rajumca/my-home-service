package com.rajuboddupalli.home.function;

import java.io.IOException;
import java.nio.file.Path;

@FunctionalInterface
public interface PathConverter<T> {
    public T convert(Path path);
}

