package com.rajuboddupalli.home.finance.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class Summary {
    private double total;
    private double avergae;
    private List<Year> years;
}
