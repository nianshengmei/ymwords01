package com.ym.common.io;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class OpXlsx {

    public List<String> fileReader(String excelPath) throws Exception {
        List<String> allWords = new LinkedList<String>();
        Workbook wb = null;
        wb = new XSSFWorkbook(new File(excelPath));
        Sheet sheet = wb.getSheetAt(0);
        for(int i=0;i<sheet.getLastRowNum();i++) {
            Row row = sheet.getRow(i);

            for(int j =1;j<2;j++) {
                Cell cell = row.getCell(j);
                if(cell!=null) {
                    allWords.add(cell.toString());
                }
            }
        }
        return allWords;
    }
}
