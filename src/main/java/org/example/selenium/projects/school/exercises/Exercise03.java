package org.example.selenium.projects.school.exercises;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.selenium.projects.school.website.orangehrmlive.XpathElement;
import org.example.selenium.utils.DataDriven;
import org.openqa.selenium.WebDriver;

public class Exercise03 extends XpathElement {
    public static Workbook workbook;
    public static DataDriven dataDriven;

    public Exercise03(WebDriver driver, String webUrl) {
        super(driver, webUrl);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        dataDriven = new DataDriven()
                .openFile("src/main/java/org/example/selenium/projects/files/de.xls")
                .openSheet(0)
                .readRowsInRange(0, 3)
                .readColsInRange(0, 3);

        workbook = dataDriven.getWorkbook();
        dataDriven.read(Exercise03::handler);
    }

    public static void handler(Row row, Cell cell, String message) {
        System.out.println(cell.getNumericCellValue());
    }

}