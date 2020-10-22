package com.rajuboddupalli.home.music.extract.converter;


import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.rajuboddupalli.home.domain.entity.music.Album;
import com.rajuboddupalli.home.domain.entity.music.Song;

import java.io.IOException;
import java.nio.file.Path;

public class SongConverter {

   // private static int count;

    public Song convert(Path path, Album album) {
        Song song = new Song();
        try {
            Mp3File mp3File = new Mp3File(path);
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            if (id3v2Tag != null&&id3v2Tag.getArtist()!=null) {
                song.getSingers().add(id3v2Tag.getArtist());
            }
//            id3v2Tag.get
            //System.out.println("****"+count++);
        } catch (IOException | UnsupportedTagException | InvalidDataException |IllegalArgumentException e) {

        }
        song.setAlbumName(album.getName());
        song.setName(path.getFileName().toString());
        song.setPath(path.toString());
//song.setArtist();
        return song;
    }
}
