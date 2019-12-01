package com.rajuboddupalli.home.music.store.repository;

import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageAuditDAO {
    @Autowired
    private ImageAuditRepository imageAuditRepository;
    public void save(ImageAudit imageAudit){
        imageAuditRepository.save(imageAudit);
    };
}

