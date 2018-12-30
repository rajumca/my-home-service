package com.rajuboddupalli.home.controller;

import com.rajuboddupalli.home.model.Summary;
import com.rajuboddupalli.home.process.FinanceProcessor;
import com.rajuboddupalli.home.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@CrossOrigin
@RestController
public class Controller {
    @Autowired
    private FinanceProcessor financeProcessor;

    @RequestMapping
    public Summary method() throws IOException {
        return financeProcessor.process();
    }
}
