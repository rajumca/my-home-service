package com.rajuboddupalli.home.music.store.repository;

import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ImageAuditRepository extends CassandraRepository<ImageAudit,String> {
}
