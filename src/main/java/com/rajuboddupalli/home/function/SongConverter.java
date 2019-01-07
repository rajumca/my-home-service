package com.rajuboddupalli.home.function;

import com.rajuboddupalli.home.entity.Song;

import java.nio.file.Path;

public class SongConverter implements PathConverter<Song> {
    @Override
    public Song convert(Path path) {
        Song song = new Song();
        /*try {
            Mp3File mp3File = new Mp3File(path);
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            if (id3v2Tag != null) {
                song.setSinger(id3v2Tag.getArtist());
            }
//            id3v2Tag.get
        } catch (IOException | UnsupportedTagException | InvalidDataException |IllegalArgumentException e) {

        }*/

        song.setName(path.getFileName().toString());
        song.setPath(path.toString());
//song.setArtist();
        return song;
    }
}
