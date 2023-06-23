package org.example.selenium.projects.school.exercises;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.example.selenium.projects.school.website.orangehrmlive.XpathElement;
import org.example.selenium.utils.DataDriven;
import org.openqa.selenium.WebDriver;

public class Exercise03 extends XpathElement {
    public String filePath = "src/main/java/org/example/selenium/projects/files/de.xls";
    public DataDriven dataDriven = new DataDriven();

    public Exercise03(WebDriver driver, String webUrl) {
        super(driver, webUrl);
    }

    public void run() {
        dataDriven
                .setFilePath(filePath)
                .openFile()
                .openSheet(0)
                .readRowsInRange(0, 4)
                .readColsInRange(0, 3)
                .read(Exercise03::handler)
                .save()
                .close();

    }

    public static void handler(Row row, Cell cell, String message) {
        Cell nCell = row.createCell(4);
        nCell.setCellValue(message);
    }

}