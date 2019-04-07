package com.rajuboddupalli.home.music.repository;

import com.rajuboddupalli.home.music.entity.Song;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CassandraRepository<Song, String> {
}
