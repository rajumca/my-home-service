package com.rajuboddupalli.home.controller;

import com.rajuboddupalli.home.photo.service.PhotoIntializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("photos")
public class PhotoController {
    @Autowired
    private PhotoIntializationService photoIntializationService;

    @GetMapping
    public void extract(){
        photoIntializationService.initiate();
    }
}
