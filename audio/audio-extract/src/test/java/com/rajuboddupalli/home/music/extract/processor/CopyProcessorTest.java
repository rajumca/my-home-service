package com.rajuboddupalli.home.music.extract.processor;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CopyProcessorTest {

    private CopyProcessor copyProcessor;

    @Test
    public void copy() {
        copyProcessor=new CopyProcessor();
        copyProcessor.copy("G:\\MUSIC\\1 - Nenokkadine (2014) ~ 320 VBR\\01 - Who R U.mp3","G:\\temp" );
        Assert.assertTrue(Files.exists(Paths.get("G:\\temp\\01 - Who R U.mp3")));
    }
}