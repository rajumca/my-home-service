package com.rajuboddupalli.home.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopyObject {
    private String sourceFile;
    private String destinationDirectory;
    private boolean createIfNotExists;
    private boolean deleteOriginal;
    private CopyObjectType copyObjectType;
    private Map<String,Object> additionalInfo;
}
