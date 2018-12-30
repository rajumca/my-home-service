package com.rajuboddupalli.home.process;

import com.rajuboddupalli.home.model.Summary;
import com.rajuboddupalli.home.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class FinanceProcessor {
    @Autowired
    private ExcelUtils excelUtils;

    public Summary process() {
        Summary summary = excelUtils.readSummary();
        summary.getYears().stream().forEach(e -> {
            e.setTotal(e.getTransactions().stream().mapToDouble(f -> Double.parseDouble(f.getInr())).sum());
            int months = 12;
            if (e.getYear() == Calendar.getInstance().get(Calendar.YEAR)) {
                months = Calendar.getInstance().get(Calendar.MONTH) - new GregorianCalendar(e.getYear(), 0, 01).get(Calendar.MONTH);
            }
            else if(e.getYear()==2015){
                months=11;
            }
            e.setAverage(e.getTotal() / months);
            e.setMonths(months);
        });
        return summary;
    }
}
