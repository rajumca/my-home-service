package com.rajuboddupalli.home.photo.service;

import com.rajuboddupalli.home.common.utils.DirectoryUtils;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit.ImageAuditBuilder;
import com.rajuboddupalli.home.photo.publisher.ImagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PhotoIntializationService {

    @Autowired
    private ImagePublisher imagePublisher;
    @Autowired
    private Environment env;

    private String  source = "F:\\Photos\\Amzon\\Amazon Photos Downloads\\Amazon Photos Downloads\\IRajuX";
//    private String source="F:\\Photos\\2019\\Amazon Photos Downloads\\IRajuX";
    private String  destination="F:\\Photos\\Amzon\\grouped";

    /*private String source = "D:\\apps\\test\\Phototest\\source";
    private String destination = "D:\\apps\\test\\Phototest\\destination";*/
    public void initiate() {

        DirectoryUtils.forEachFile(Paths.get(source), source -> process(source, Paths.get(destination)));
    }

    private void process(Path source, Path destination) {
        if (!source.toString().contains("MOV")) {
            ImageAudit imageAudit = getImageAudit(source);

            imagePublisher.audit(imageAudit);
            imagePublisher.publish(imageAudit);
        }
    }

    private ImageAudit getImageAudit(Path path) {
        ImageAuditBuilder imageAuditBuilder = ImageAudit.builder();
        return imageAuditBuilder.path(path.toString()).name(path.getFileName().toString()).destination(destination.toString()).migrationStatus("QUEUED").build();
    }
}
