package com.rajuboddupalli.home.utils;

import com.rajuboddupalli.home.entity.Summary;
import com.rajuboddupalli.home.entity.Transaction;
import com.rajuboddupalli.home.entity.Year;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelUtils {

    Workbook workbook;

    public ExcelUtils() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(new File("F:\\XL\\My Finance.xlsx"))) {
            workbook = new XSSFWorkbook(fileInputStream);

        }
    }

    public String getTotal() {

        return Double.toString(getNumber(getSheetAt(0), 1, 1));
    }

    public Summary readSummary() {
        Summary summary = new Summary();
        summary.setTotal(getNumber(getSheetAt(0), 1, 1));
        List<Year> years = new ArrayList<>();

        Sheet y2018 = workbook.getSheetAt(1);
        Sheet y2017 = workbook.getSheetAt(2);
        Sheet y2016 = workbook.getSheetAt(3);
        Sheet y2015 = workbook.getSheetAt(4);
        years.add(getYear(y2018));
        years.add(getYear(y2017));
        years.add(getYear(y2016));
        years.add(getYear(y2015));
        summary.setYears(years);
        return summary;

    }

    private Year getYear(Sheet sheet) {
        Iterator<Row> rows = sheet.rowIterator();
        Year year = new Year();
        List<Transaction> transactions = new ArrayList<>();
        while (rows.hasNext()) {

            Row row = rows.next();
            int rowNum = row.getRowNum();
            if (rowNum != 0) {
                Transaction transaction = getTransaction(row);
                if(transaction.getDate()==null||transaction.getDate().equals("")){
                    break;
                }
                transactions.add(transaction);
            }
        }
        year.setYear(Integer.parseInt(sheet.getSheetName()));
        year.setTransactions(transactions);
        return year;
    }

    private Transaction getTransaction(Row row) {
        if (row == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setDate(getDate(row));
        transaction.setUsd(getStringValue(row,1));
        transaction.setInr(getStringValue(row,2));
        transaction.setSentTo(getTextValue(row, 3));
        return transaction;
    }

    private String getDate(Row row) {

        Cell cell = row.getCell(0);
        if (cell == null) return "";
        try {
//            if (cell.getCellTypeEnum() == CellType.NUMERIC) {
//                return new Date((int) cell.getNumericCellValue()).toString();
//            } else if (cell.getCellTypeEnum() == CellType.STRING) {
//                return cell.getStringCellValue();
//            }
             SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String format = sdf.format(cell.getDateCellValue());
            return format;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getStringValue(Row row,int  index) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            return "";
        }
        double numericCellValue = cell.getNumericCellValue();

        return new Double(numericCellValue).toString();
    }

    private String getTextValue(Row row,int  index) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            return "";
        }
       return cell.getStringCellValue();
    }

    private Sheet getSheetAt(int i) {
        return workbook.getSheetAt(i);
    }

    public double getNumber(Sheet sheet, int row, int col) {
        return sheet.getRow(1).getCell(1).getNumericCellValue();
    }

    public String getString(Sheet sheet, int row, int col) {
        return sheet.getRow(1).getCell(1).getStringCellValue();
    }
}
