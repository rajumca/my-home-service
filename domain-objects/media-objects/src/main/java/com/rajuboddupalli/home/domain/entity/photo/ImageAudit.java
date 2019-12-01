package com.rajuboddupalli.home.domain.entity.photo;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table(value = "image_audit")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ImageAudit implements Serializable {

    private static final long serialVersionUID = -8160687260013445623L;

    @PrimaryKeyColumn(name = "name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String name;
    @Column
    private String year;
    @Column
    private String month;
    @Column
    private String path;

    @Column
    private  String destination;

    @Column("migration_status")
    private String migrationStatus;
}
