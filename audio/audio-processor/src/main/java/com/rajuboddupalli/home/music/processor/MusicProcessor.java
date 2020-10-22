package com.rajuboddupalli.home.music.processor;

import com.rajuboddupalli.home.common.utils.DirectoryUtils;
import com.rajuboddupalli.home.domain.entity.music.Album;
import com.rajuboddupalli.home.music.publisher.CopyMessagePublisher;
import com.rajuboddupalli.home.music.publisher.ExtractMessagePublisher;
import com.rajuboddupalli.home.music.store.repository.MusicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class MusicProcessor {
    @Autowired
    private MusicDAO musicDAO;

    @Autowired
    private ExtractMessagePublisher extractPublisher;

    @Autowired
    private CopyMessagePublisher copyMessagePublisher;

    public void extract() {
        System.out.println("Processor:** " + LocalDateTime.now());
        Path musicPath = Paths.get("G:\\MUSIC");
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(musicPath)) {
            StreamSupport.stream(paths.spliterator(), true).forEach(path -> extractPublisher.publish(path.toString()));
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public List<Album> getAlbums() throws IOException {
        return musicDAO.findAll();
    }

    public void copy(String filePathString, String targetFolder) throws IOException {
        publish(Paths.get(filePathString), targetFolder);
    }

    private void publish(Path path, String targetFolder) {
        if (Files.isDirectory(path)) {
            DirectoryUtils.forEachFile(path, subPath->publish(subPath,targetFolder));
        } else {
            copyMessagePublisher.publish(path.toString(), targetFolder);
        }
    }


}
