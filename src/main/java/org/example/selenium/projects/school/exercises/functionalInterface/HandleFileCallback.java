package org.example.selenium.projects.school.exercises.functionalInterface;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public interface HandleFileCallback {
    void back(Row row, Cell cell, String message);
}
