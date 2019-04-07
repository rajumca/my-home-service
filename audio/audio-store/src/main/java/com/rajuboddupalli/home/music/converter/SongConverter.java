package com.rajuboddupalli.home.music.converter;


import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.entity.domain.Song;

import java.nio.file.Path;

public class SongConverter {

    private static int count;


    public Song convert(Album album, Path path) {
        Song song = new Song();
     /*   try {
            Mp3File mp3File = new Mp3File(path);
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            if (id3v2Tag != null) {
                song.getSingers().add(id3v2Tag.getArtist());
            }
//            id3v2Tag.get
            System.out.println("****"+count++);
        } catch (IOException | UnsupportedTagException | InvalidDataException |IllegalArgumentException e) {

        }*/

        song.setName(path.getFileName().toString());
        song.setPath(path.toString());
//song.setArtist();
        return song;
    }
}
