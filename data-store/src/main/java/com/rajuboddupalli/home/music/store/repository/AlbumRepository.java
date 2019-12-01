package com.rajuboddupalli.home.music.store.repository;

import com.rajuboddupalli.home.domain.entity.music.Album;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CassandraRepository<Album, String> {
}
