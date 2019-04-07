package com.rajuboddupalli.home.music.repository;

import com.rajuboddupalli.home.music.entity.Album;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CassandraRepository<Album, String> {
//    List<Album> findAll();
//
//    List<Album> insert(List<Album> albums);
//
//    Album insert(Album album);
}
