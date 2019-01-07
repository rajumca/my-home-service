package com.rajuboddupalli.home.repository;

import com.rajuboddupalli.home.entity.Album;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CassandraRepository<Album, String> {
//    List<Album> findAll();
//
//    List<Album> insert(List<Album> albums);
//
//    Album insert(Album album);
}
