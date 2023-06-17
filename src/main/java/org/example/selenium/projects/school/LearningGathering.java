package org.example.selenium.projects.school;

import org.example.selenium.projects.school.web.Elearning;
import org.example.selenium.projects.school.web.Globalsqa;
import org.example.selenium.projects.school.web.Omayo;
import org.example.selenium.projects.school.web.Petstore;
import org.example.selenium.setup.Driver;
import org.example.selenium.setup.PropertiesFile;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LearningGathering {

    static  Driver driver = new Driver();
    static Properties configFile = new PropertiesFile("config.properties").read();
    public static void main(String[] args) {
        new Omayo(driver.useChrome(),"http://omayo.blogspot.com/p/page7.html").downloadFile().quit();
        // new Petstore(driver.useChrome(), "https://petstore.octoperf.com/actions/Catalog.action", configFile).login().signOut().quit();
        // new Globalsqa(driver.useChrome(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",configFile).login().quit();
        // new Elearning(driver.useChrome(),"https://elearning.vanlanguni.edu.vn/",configFile).login().openDashboard();
    }
}
