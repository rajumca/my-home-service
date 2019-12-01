
package com.rajuboddupalli.home.common.filecopy.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.CopyObject;
import com.rajuboddupalli.home.common.domain.CopyObjectType;
import com.rajuboddupalli.home.common.filecopy.publisher.ImageStoreMessagePublisher;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Component
public class CopyProcessor {

    @Autowired
    private ImageStoreMessagePublisher storeMessagePublisher;

    public void copy(CopyObject copyObject) {
        try {
            Path source = Paths.get(copyObject.getSourceFile());
            createIfDirectoryDoesnotExists(copyObject);
            Files.copy(source, getDestinationPath(copyObject, source), REPLACE_EXISTING);
            if (copyObject.isDeleteOriginal()) {
                Files.delete(source);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        audit(copyObject);
    }

    private void createIfDirectoryDoesnotExists(CopyObject copyObject) {
        File destDir = new File(copyObject.getDestinationDirectory());
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
    }

    private Path getDestinationPath(CopyObject copyObject, Path source) {
        return Paths.get(copyObject.getDestinationDirectory()).resolve(source.getFileName());
    }


    private void audit(CopyObject copyObject) {
        if (copyObject.getCopyObjectType().equals(CopyObjectType.IMAGE)) {
            ImageAudit audit = new ObjectMapper().convertValue(copyObject.getAdditionalInfo().get("AUDIT"), ImageAudit.class);
            audit.setMigrationStatus("COMPLETED");
            storeMessagePublisher.audit(audit);
        }
    }

}
