package org.example.selenium.projects.school;

import org.example.selenium.projects.school.website.orangehrmlive.models.myInfo.PersonalDetails;
import org.example.selenium.projects.school.exercises.*;
import org.example.selenium.setup.Driver;
import org.example.selenium.setup.PropertiesFile;

import java.util.Properties;

public class Run {

    static Driver driver = new Driver();
    static Properties configFile = new PropertiesFile("config.properties").read();

    public static void main(String[] args) {
//        doExercise01();
        doExercise02();
    }

    public static void doExercise01() {

    }

    public static void doExercise02() {
        PersonalDetails material02 = new PersonalDetails()
                .setFirstName("Automation")
                .setMiddleName("STT nhóm")
                .setLastName("Ca học")
                .setNickName("Testing")
                .setEmployeeId("stt nhóm")
                .setOtherId("stt nhóm * 10")
                .setDriverLicenseNumber("11111")
                .setLicenseExpiryDate("2023-06-18")
                .setSsnNumber("300")
                .setSinNumber("")
                .setNationality("tự chọn")
                .setMaterialStatus("Single")
                .setGender("Female")
                .setMilitaryService("1")
                .setSmoker("no");

        Exercise02 exercise02 = new Exercise02(driver.useChrome(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        exercise02.login().updateMyInfo(material02).pause(5000).quit();

    }
}
