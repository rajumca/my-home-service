package com.rajuboddupalli.home.photo.receiver;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.CopyObject;
import com.rajuboddupalli.home.common.domain.CopyObjectType;
import com.rajuboddupalli.home.common.logger.LoggingUtils;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import com.rajuboddupalli.home.photo.publish.FileCopyPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@Component
public class RecieveImageExtarct {

    public static final String ERROR = "ERROR";
    @Autowired
    private FileCopyPublisher fileCopyPublisher;

    @KafkaListener(topics = "MYHOME.IMAGE.EXTRACT", groupId = "image-processor")
    public void receiveFilePath(String message) {
        ImageAudit imageAudit = null;
        try {
            imageAudit = new ObjectMapper().readValue(message, ImageAudit.class);
            extractAndPublish(imageAudit);
        } catch (Exception e) {
            imageAudit.setMigrationStatus("ERROR");
            fileCopyPublisher.audit(imageAudit);
            LoggingUtils.logError("Error reading image metadata: " + imageAudit != null ? imageAudit.getName() : "", e);
        }
        fileCopyPublisher.audit(imageAudit);
    }


    public void extractAndPublish(ImageAudit imageAudit) throws JsonProcessingException {

        CopyObject copyObject = getCopyObject(imageAudit);
        if (!imageAudit.getMigrationStatus().equals(ERROR)) {
            fileCopyPublisher.publish(copyObject);
            imageAudit.setMigrationStatus("INPROCESS");
            imageAudit.setDestination(copyObject.getDestinationDirectory());
        }


    }

    public CopyObject getCopyObject(ImageAudit imageAudit) {
        CopyObject copyObject = new CopyObject();
        try {
            copyObject.setSourceFile(imageAudit.getPath());
            copyObject.setCreateIfNotExists(true);
            copyObject.setCopyObjectType(CopyObjectType.IMAGE);
            copyObject.setDestinationDirectory(setAndGetDestinationDirectory(imageAudit));
            copyObject.setDeleteOriginal(true);
            Map<String, Object> additionalInfo = new HashMap<>();
            additionalInfo.put("AUDIT", imageAudit);
            copyObject.setAdditionalInfo(additionalInfo);

        } catch (Exception e) {
            imageAudit.setMigrationStatus(ERROR);
            LoggingUtils.logError(imageAudit.getName(), e);
        }
        return copyObject;
    }

    private String setAndGetDestinationDirectory(ImageAudit imageAudit) throws ImageProcessingException, IOException {
        Optional<Calendar> calendarObject = extractCreationDate(imageAudit.getPath());
        return calendarObject.map(calendar -> {
            int month = calendar.get(Calendar.MONTH)+1;
            int year = calendar.get(Calendar.YEAR);
            imageAudit.setYear(Integer.toString(year));
            imageAudit.setMonth(Integer.toString(month));
            imageAudit.setDestination(new StringBuilder(imageAudit.getDestination()).append("\\").append(year).append("\\").append(month).toString());
            return imageAudit.getDestination();
        }).orElseGet(() -> {
            imageAudit.setDestination(new StringBuilder(imageAudit.getDestination()).append("\\").append("manual").toString());
            return imageAudit.getDestination();
        });
    }

    private Optional<Calendar> extractCreationDate(String path) throws ImageProcessingException, IOException {
        Calendar calendar = null;
        Metadata metadata = ImageMetadataReader.readMetadata(Paths.get(path).toFile());
        ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        if (directory != null && directory.getDateOriginal() != null) {
            Date dateOriginal = directory.getDateOriginal();
            calendar = Calendar.getInstance();
            calendar.setTime(dateOriginal);
        }
        return Optional.ofNullable(calendar);
    }

//    public static void main(String[] args) throws ImageProcessingException, IOException {
//        Metadata metadata = ImageMetadataReader.readMetadata(Paths.get("F:\\Photos\\2019\\Amazon Photos Downloads\\IRajuX\\2016-06-14_14-35-32_335.jpeg").toFile());
//        ExifSubIFDDirectory directoryOfType = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
//        Date dateOriginal = directoryOfType.getDateOriginal();
//        ;
//
//    }


}
