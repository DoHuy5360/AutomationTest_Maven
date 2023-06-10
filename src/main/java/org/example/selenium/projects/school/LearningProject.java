package org.example.selenium.projects.school;

import org.example.selenium.TestAction;
import org.example.selenium.projects.school.web.Globalsqa;
import org.example.selenium.projects.school.web.Petstore;
import org.example.selenium.setup.Browser;
import org.example.selenium.setup.PropertiesFile;
import org.example.selenium.utils.PrintColor;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LearningProject {
    static Properties properties = new PropertiesFile("config.properties").read();
    public static void main(String[] args) {
        new Browser().useEdge().execute((driver)-> {
//            new Petstore(driver, "https://petstore.octoperf.com/actions/Catalog.action", properties).login().signOut().quit();
            new Globalsqa(driver, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",properties).login().quit();
        });
    }
}
