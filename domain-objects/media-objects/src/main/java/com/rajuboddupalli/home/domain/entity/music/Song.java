package com.rajuboddupalli.home.domain.entity.music;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
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

    public List<String> getSingers() {
        if (singers == null) {
            singers = new ArrayList<>();
        }
        return singers;
    }
}
