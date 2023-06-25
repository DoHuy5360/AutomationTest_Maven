package org.example.selenium.projects.school.exercises;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.example.selenium.projects.school.website.orangehrmlive.XpathElement;
import org.example.selenium.utils.DataDriven;
import org.openqa.selenium.WebDriver;

public class DataDrivenPractice extends XpathElement {
    public static String filePath = "src/main/java/org/example/selenium/projects/files/de.xls";
    public static DataDriven dataDriven = new DataDriven();

    public DataDrivenPractice(WebDriver driver, String webUrl) {
        super(driver, webUrl);
    }
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        dataDriven
                .setFilePath(filePath)
                .openFile()
                .openSheet(0)
                .readRowsInRange(0, 4)
                .readColsInRange(0, 3)
                .read(DataDrivenPractice::handler)
                .save()
                .close();

    }

    public static void handler(Row row, String message) {
        Cell nCell = row.createCell(4);
        nCell.setCellValue(message);
        System.out.println(row.getCell(0));
        System.out.println(row.getCell(1));
        System.out.println(row.getCell(2));
        System.out.println(row.getCell(3));
    }

}