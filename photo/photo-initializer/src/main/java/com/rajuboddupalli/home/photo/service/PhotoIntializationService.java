package com.rajuboddupalli.home.photo.service;

import com.rajuboddupalli.home.common.utils.DirectoryUtils;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit.ImageAuditBuilder;
import com.rajuboddupalli.home.photo.publisher.ImagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PhotoIntializationService {

    @Autowired
    private ImagePublisher imagePublisher;
    @Autowired
    private Environment env;

    private String source = "F:\\Photos\\Ungrouped";
    //    private String source="F:\\Photos\\2019\\Amazon Photos Downloads\\IRajuX";
    private String destination = "F:\\Photos\\Amzon\\grouped";
//    private String destination = "F:\\Photos\\test-grouped";
    /*private String source = "D:\\apps\\test\\Phototest\\source";
    private String destination = "D:\\apps\\test\\Phototest\\destination";*/
    public void initiate() {

        processDirectory(source, destination);
    }

    private void processDirectory(String from, String target) {
        DirectoryUtils.forEachFile(Paths.get(from), source -> process(source, Paths.get(target)));
    }

    private void process(Path source, Path destination) {
        if (Files.isDirectory(source)) {
            processDirectory(source.toString(), destination.toString());
        } else if (!source.toString().contains("MOV")) {
            ImageAudit imageAudit = getImageAudit(source, destination);

            imagePublisher.audit(imageAudit);
            imagePublisher.publish(imageAudit);
        }
    }

    private ImageAudit getImageAudit(Path path, Path destination) {
        ImageAuditBuilder imageAuditBuilder = ImageAudit.builder();
        return imageAuditBuilder.path(path.toString()).name(path.getFileName().toString()).destination(destination.toString()).migrationStatus("QUEUED").build();
    }
}
