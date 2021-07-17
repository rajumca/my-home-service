package com.rajuboddupalli.home.music.extract.converter;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.rajuboddupalli.home.domain.entity.music.Album;
import com.rajuboddupalli.home.domain.entity.music.Song;
import com.rajuboddupalli.home.music.extract.utils.SubDirectoryUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlbumConverter {
    public Album convert(Path path) {
        Album album = new Album();
        album.setName(path.getFileName().toString());
        album.setPath(path.toString());
        setSongs(path, album);
        setAlbumProperties(album);
        if (album.getYear() == 0) {
            setYear(album);
        }
        return album;
    }

    private void setAlbumProperties(Album album) {
        if (album.getSongs() != null && !album.getSongs().isEmpty()) {
            try {
                Optional<Song> value = album.getSongs().stream().filter(song -> song.getPath().contains("mp3")).findAny();
                if (value.isPresent()) {
                    String path1 = value.get().getPath();
                    Mp3File mp3File = new Mp3File(Paths.get(path1));
                    ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                    if (id3v2Tag != null) {
                        album.setComposer(id3v2Tag.getComposer());
                        if (id3v2Tag.getAlbumImage() != null) {
                            album.setImage(ByteBuffer.wrap(id3v2Tag.getAlbumImage()));
                        }
                        String year = id3v2Tag.getYear();
                        if (year != null && year != null && !year.trim().equals("") && Pattern.compile("\\d{4}").matcher(year).matches()) {

                            album.setYear(Integer.parseInt(year));
                        }
                    }
                }
            } catch (IOException | UnsupportedTagException | InvalidDataException e) {

            }
        }
    }

    private void setSongs(Path path, Album album) {
        try {
            album.setSongs(new SubDirectoryUtils().getList(path, new SongConverter(), album));
        } catch (IOException e) {
            album.setSongs(null);
        }
    }

    private void setYear(Album album) {
        Matcher matcher = Pattern.compile("\\(\\d{4}\\)").matcher(album.getName());
        if (matcher.find()) {
            String year = matcher.group();
            album.setYear(Integer.parseInt(year.substring(1, 5)));
        }
    }
}
