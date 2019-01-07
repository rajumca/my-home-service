package com.rajuboddupalli.home.controller;

import com.rajuboddupalli.home.entity.Summary;
import com.rajuboddupalli.home.process.FinanceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@CrossOrigin
@RestController
@RequestMapping("finance")
public class FinanceController {
    @Autowired
    private FinanceProcessor financeProcessor;

    @GetMapping
    public Summary getSummary() throws IOException {
        return financeProcessor.process();
    }
}
