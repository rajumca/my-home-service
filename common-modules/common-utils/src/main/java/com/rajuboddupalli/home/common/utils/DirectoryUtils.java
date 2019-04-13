package com.rajuboddupalli.home.common.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public final class DirectoryUtils {

        public static void forEachFile(Path filePath,Consumer<Path> forEachOperation){
            try (DirectoryStream<Path> paths = Files.newDirectoryStream(filePath)) {
                StreamSupport.stream(paths.spliterator(), true).forEach(forEachOperation);
            } catch (IOException e) {
                System.err.println("Error iterating the directory: "+filePath+e.getMessage());
            }
        }

}
