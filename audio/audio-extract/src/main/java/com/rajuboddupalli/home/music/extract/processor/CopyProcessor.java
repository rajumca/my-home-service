package com.rajuboddupalli.home.music.extract.processor;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Component
public class CopyProcessor {
    public void copy(String  path, String targetFolder){
        try {
            Path source = Paths.get(path);
            Files.copy(source, Paths.get(targetFolder).resolve(source.getFileName()), REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error copying file:"+path+e.getMessage());
        }

    }

}
