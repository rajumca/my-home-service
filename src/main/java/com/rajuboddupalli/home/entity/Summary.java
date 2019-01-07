package com.rajuboddupalli.home.entity;

import java.util.List;

public class Summary {
    private double total;
    private double avergae;
    private List<Year> years;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAvergae() {
        return avergae;
    }

    public void setAvergae(double avergae) {
        this.avergae = avergae;
    }

    public List<Year> getYears() {
        return years;
    }

    public void setYears(List<Year> years) {
        this.years = years;
    }
}
