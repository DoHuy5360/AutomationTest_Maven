package org.example.selenium.projects.school.website.orangehrmlive.entityProvider;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.example.selenium.projects.school.website.orangehrmlive.DTO.myInfo.PersonalDetails;
import org.example.selenium.utils.DataDriven;

public class PersonalDetailsE {
        public static String filePath = "src/main/java/org/example/selenium/projects/files/dataTest.xls";
        public static PersonalDetails[] personalDetails;
        public static PersonalDetails[] getPersonalDetails() {
                DataDriven dataConfig = new DataDriven()
                        .setFilePath(filePath).openFile().openSheet(0);
                int totalRow = (int) dataConfig.getCell(1,0).getNumericCellValue();
                dataConfig.close();

                personalDetails = new PersonalDetails[totalRow];
                new DataDriven().setFilePath(filePath)
                                .openFile()
                                .openSheet(1)
                                .readRowsInRange(1, totalRow)
                                .read(PersonalDetailsE::handler)
                                .save()
                                .close();
                return personalDetails;
        }
        public static void handler(Row row, String message) {
                personalDetails[row.getRowNum()-1] = new PersonalDetails()
                                .setFirstName(row.getCell(0).getStringCellValue())
                                .setMiddleName(row.getCell(1).getStringCellValue())
                                .setLastName(row.getCell(2).getStringCellValue())
                                .setNickName(row.getCell(3).getStringCellValue())
                                .setEmployeeId(row.getCell(4).getStringCellValue())
                                .setOtherId(row.getCell(5).getStringCellValue())
                                .setDriverLicenseNumber(row.getCell(6).getStringCellValue())
                                .setLicenseExpiryDate(row.getCell(7).getStringCellValue())
                                .setSsnNumber(row.getCell(8).getStringCellValue())
                                .setSinNumber(row.getCell(9).getStringCellValue())
                                .setNationality(row.getCell(10).getStringCellValue())
                                .setMaterialStatus(row.getCell(11).getStringCellValue())
                                .setGender(row.getCell(12).getStringCellValue())
                                .setMilitaryService(row.getCell(13).getStringCellValue())
                                .setSmoker(row.getCell(14).getStringCellValue());
        }
}
