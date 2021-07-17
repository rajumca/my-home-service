package com.rajuboddupalli.home.domain.entity.music;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
@Setter
@Getter
@Table(value = "album")
public class Album implements Serializable {

    @PrimaryKeyColumn(name = "name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String name;

    @Column
    private int accessed;

    @Column
    private String composer;

    @Column
    private String path;
    @Column
    private int rating;

    @Column
    private int year;

    @Transient
    private List<Song> songs;

    @Column
    private ByteBuffer image;


}
