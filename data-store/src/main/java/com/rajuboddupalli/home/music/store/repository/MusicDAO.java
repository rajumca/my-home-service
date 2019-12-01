package com.rajuboddupalli.home.music.store.repository;


import com.rajuboddupalli.home.domain.entity.music.Album;
import com.rajuboddupalli.home.domain.entity.music.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MusicDAO {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    public void insert(Album album) {
        albumRepository.insert(album);
        if (album.getSongs() != null && album.getSongs().size() > 0) {
            songRepository.insert(album.getSongs());
        }
    }

    public List<Album> findAll() {
        List<Album> albums = albumRepository.findAll();
        List<Song> songs = songRepository.findAll();
        Map<String, List<Song>> songsMap = songs.stream().collect(Collectors.groupingBy(song -> song.getAlbumName()));
        albums.stream().forEach(album -> album.setSongs(songsMap.get(album.getName())));
        return albums;
    }


}
