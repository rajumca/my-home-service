package com.rajuboddupalli.home.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.List;

@Table(value = "song")
public class Song implements Serializable {

    @PrimaryKeyColumn(name = "album_name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String albumName;
    @PrimaryKeyColumn(name = "name", ordinal = 1)
    private String name;
    @Column("accessed")
    private int accessed;
    @Column("lyricist")
    private String lyricist;
    @Column("path")
    private String path;
    @Column("rating")
    private int rating;
    @Column("singers")
    private List<String> singers;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccessed() {
        return accessed;
    }

    public void setAccessed(int accessed) {
        this.accessed = accessed;
    }


    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getSingers() {
        return singers;
    }

    public void setSingers(List<String> singers) {
        this.singers = singers;
    }
}
