package com.rajuboddupalli.home.music.repository;


import com.rajuboddupalli.home.music.entity.domain.Album;
import com.rajuboddupalli.home.music.entity.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MusicDAO {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    /*public List<Album> insert() throws IOException {
        List<Album> albums = musicProcessor.getAlbums();
        albumRepository.insert(albums);
        albums.stream().forEach(album -> {
            if (album.getSongs() != null)
                album.getSongs().stream().forEach(song -> song.setAlbumName(album.getName()));
        });
        List<Song> songs = new ArrayList<>();
        albums.stream().forEach(album -> {
            if (album.getSongs() != null) {
                songs.addAll(album.getSongs());
            }
        });
        System.out.println("***************:"+songs);
        songRepository.saveAll(songs);
//        List<List<Song>> collect = albums.stream().map(album -> album.getSongs()).collect(Collectors.toCollection(()->so));
        return albums;
    }*/
    public void insert(Album album) {
        albumRepository.insert(album);
        if (album.getSongs() != null&& album.getSongs().size()>0) {
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
