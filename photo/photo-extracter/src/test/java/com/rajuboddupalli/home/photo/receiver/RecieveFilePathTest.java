//package com.rajuboddupalli.home.photo.receiver;
//
//import com.drew.imaging.ImageProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rajuboddupalli.home.common.domain.CopyObject;
//import com.rajuboddupalli.home.common.domain.CopyObjectType;
//import com.rajuboddupalli.home.photo.publish.FileCopyPublisher;
//import org.junit.Before;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.HashMap;
//
//import static org.junit.Assert.assertEquals;
//
//public class RecieveFilePathTest {
//
//
//    private RecieveImageExtarct recieveFilePath=new RecieveImageExtarct();
//    private FileCopyPublisher fileCopyPublisher=new FileCopyPublisher();
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @org.junit.Test
//    public void receiveFilePathFOrImage() throws ImageProcessingException, IOException {
//  /*      Metadata metadata = ImageMetadataReader.readMetadata(Paths.get("F:\\Photos\\spices\\20141101_223559.jpg").toFile());
//        ExifSubIFDDirectory directoryOfType = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
//        Date dateOriginal = directoryOfType.getDateOriginal();*/
//        String message = new ObjectMapper().writeValueAsString(new CopyObject("F:\\Photos\\spices\\20141101_223559.jpg", "F:\\Photos\\spices\\test", false, false, CopyObjectType.IMAGE,new HashMap<>()));
//        CopyObject copyObject = recieveFilePath.getCopyObject(message);
//        assertEquals(copyObject.getDestinationDirectory(), "F:\\Photos\\spices\\test\\2014\\10");
//        //fileCopyPublisher.publish(copyObject);
//        Path path = Paths.get("F:\\Photos\\2019\\2019-09\\IMG_1162.MOV");
//        System.out.println(path.toString().contains("MOV"));
//    }
//    @org.junit.Test
//    public void receiveFilePathFOrVideo() throws ImageProcessingException, IOException {
//  /*      Metadata metadata = ImageMetadataReader.readMetadata(Paths.get("F:\\Photos\\spices\\20141101_223559.jpg").toFile());
//        ExifSubIFDDirectory directoryOfType = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
//        Date dateOriginal = directoryOfType.getDateOriginal();*/
//        String message = new ObjectMapper().writeValueAsString(new CopyObject("F:\\Photos\\2019\\2019-09\\IMG_1162.MOV", "F:\\Photos\\spices\\test", false, false,CopyObjectType.IMAGE,new HashMap<>()));
//        CopyObject copyObject = recieveFilePath.getCopyObject(message);
//        assertEquals(copyObject.getDestinationDirectory(), "F:\\Photos\\spices\\test\\2014\\10");
//        //fileCopyPublisher.publish(copyObject);
//
//
//    }
//
//}