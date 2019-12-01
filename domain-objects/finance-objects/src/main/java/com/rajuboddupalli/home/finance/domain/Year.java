package com.rajuboddupalli.home.finance.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Year {
    private int year;
    private double total;
    private int months;
    private double average;
    private List<Transaction> transactions;

}
