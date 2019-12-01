package com.rajuboddupalli.home.music.store.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.common.domain.StoreObject;
import com.rajuboddupalli.home.common.logger.LoggingUtils;
import com.rajuboddupalli.home.domain.entity.photo.ImageAudit;
import com.rajuboddupalli.home.music.store.repository.ImageAuditDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements StorageService{
    @Autowired
    private ImageAuditDAO imageAuditDAO;
    @Override
    public void process(StoreObject storeObject) {
        ImageAudit imageAudit=null;
        try {
            ObjectMapper objectMapper=new ObjectMapper();
             imageAudit = objectMapper.convertValue(storeObject.getData(), ImageAudit.class);
//            imageAudit = (ImageAudit) storeObject.getData();
            LoggingUtils.logInfo("STORING"+imageAudit.getName()+",Status: "+imageAudit.getMigrationStatus());
            imageAuditDAO.save(imageAudit);
        }catch (Exception e){
            e.printStackTrace();
            LoggingUtils.logError("Error in store: "+imageAudit!=null?imageAudit.getMigrationStatus():""+" "+imageAudit!=null?imageAudit.getName():"",e);
        }
    }

    @Override
    public StorageType getType() {
        return StorageType.IMAGE_AUDIT;
    }
}
