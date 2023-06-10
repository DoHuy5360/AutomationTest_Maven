package org.example.selenium.projects.school.web;

import org.example.selenium.TestAction;
import org.example.selenium.utils.PrintColor;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Petstore extends TestAction {
    public Petstore(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }
    public Petstore login(){
        PrintColor.green("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        String signInPath = "//a[text()=\"Sign In\"]";
        String registerPath = "//a[text()=\"Register Now!\"]";

        String userName = "//input[@name=\"username\"]";
        String paswName = "//input[@name=\"password\"]";
        get(webUrl)
                .click("//img[@src=\"../images/sm_fish.gif\"]").pause(500)
                .click("//img[@src=\"../images/sm_dogs.gif\"]").pause(500)
                .click("//img[@src=\"../images/sm_reptiles.gif\"]").pause(500)
                .click("//img[@src=\"../images/sm_cats.gif\"]").pause(500)
                .click("//img[@src=\"../images/sm_birds.gif\"]").pause(500)
                .click(signInPath)
                .getText(signInPath, PrintColor::turquoise)
                .sendKeys(userName, "888")
                .clear(paswName)
                .sendKeys(paswName, "123")
                .click("//input[@name=\"signon\"]");
        return this;
    }
    public void signOut(){
        pause(3000)
                .click("//a[text()=\"Sign Out\"]");
    }
}
