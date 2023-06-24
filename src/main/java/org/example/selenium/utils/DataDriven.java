package org.example.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.selenium.projects.school.exercises.functionalInterface.HandleFileCallback;

public class DataDriven {

    public FileInputStream file;
    public Workbook workbook;
    public Sheet sheet;
    public String filePath;

    public int startRow;
    public int endRow;

    public int startCol;
    public int endCol;

    public Row row;
    public Cell cell;

    public DataDriven() {

    }

    public DataDriven openFile() {
        try {
            file = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public DataDriven openSheet(int sheetNumber) {
        sheet = workbook.getSheetAt(sheetNumber);
        return this;
    }

    public DataDriven readRowsInRange(int from, int to) {
        startRow = from;
        endRow = to;
        return this;
    }

    public DataDriven readColsInRange(int from, int to) {
        startCol = from;
        endCol = to;
        return this;
    }

    public DataDriven read(HandleFileCallback call) {
        int r = startRow;
        try {
            for (; r < endRow; r++) {
                row = sheet.getRow(r);
                call.back(row, String.format("Done at row %d", r));
            }
        } catch (Exception e) {
            e.printStackTrace();
            call.back(row, String.format("Fail at row %d", r));
        }
        return this;
    }

    public DataDriven save() {
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public DataDriven close() {
        try {

            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public DataDriven setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public FileInputStream getFile() {
        return file;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getEndCol() {
        return endCol;
    }

    public Row getRow() {
        return row;
    }

    public Cell getCell() {
        return cell;
    }
}