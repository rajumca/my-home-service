package com.rajuboddupalli.home.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAccessed() {
        return accessed;
    }

    public void setAccessed(int accessed) {
        this.accessed = accessed;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
