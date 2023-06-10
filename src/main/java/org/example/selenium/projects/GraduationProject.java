package org.example.selenium.projects;

import org.example.selenium.TestAction;
import org.example.selenium.setup.Browser;
import org.example.selenium.setup.PropertiesFile;
import org.example.selenium.utils.PrintColor;
import org.openqa.selenium.WebDriver;


import java.util.Properties;

public class GraduationProject {
    static String webUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    static Properties properties = new PropertiesFile("config.properties").read();
    static String userName = properties.getProperty("graduation.name");
    static String userPasw = properties.getProperty("graduation.password");
    public static void main(String[] args) {
        new Browser().useEdge().execute((driver)->{
            new Actions(driver, webUrl, properties).login(userName, userPasw);
        });
    }
}

class Actions extends TestAction {
    public Actions(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }
    public Actions login(String userName, String userPasw) {
        PrintColor.green("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        try {
            get(this.webUrl)
            .pause(3000)
            .sendKeys("//input[@name='username']", userName)
            .sendKeys("//input[@name='password']", userPasw)
            .click("//button[@type='submit']")
            .pause(7000)
            .quit()
            ;
        } catch (Exception e){
            PrintColor.red("Unexpected errors have appeared in login() steps.");
            System.exit(1);
        }
        PrintColor.turquoise("login() passed!");
        return this;
    }
}