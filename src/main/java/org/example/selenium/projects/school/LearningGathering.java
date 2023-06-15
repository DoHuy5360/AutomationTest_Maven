package org.example.selenium.projects.school;

import org.example.selenium.projects.school.web.Omayo;
import org.example.selenium.setup.Browser;
import org.example.selenium.setup.PropertiesFile;

import java.io.IOException;
import java.util.Properties;

public class LearningGathering {
    static Properties properties = new PropertiesFile("config.properties").read();
    public static void main(String[] args) {
        new Browser().useChrome().execute((driver)-> {
//            new Petstore(driver, "https://petstore.octoperf.com/actions/Catalog.action", properties).login().signOut().quit();
//            new Globalsqa(driver, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",properties).login().quit();
//            new Elearning(driver,"https://elearning.vanlanguni.edu.vn/",properties).login().openDashboard();
            new Omayo(driver, "http://omayo.blogspot.com/p/page7.html", properties).downloadFile().quit();
        });
    }
}
