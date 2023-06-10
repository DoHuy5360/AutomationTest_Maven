package org.example.selenium.projects.school.web;

import org.example.selenium.TestAction;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Globalsqa extends TestAction {
    public Globalsqa(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }

    public Globalsqa login() {
        get(this.webUrl)
                .click("//button[@ng-click=\"customer()\"]")
                .click("//select[@name=\"userSelect\"]").pause(500)
                .click("//option[@ng-repeat=\"cust in Customers\" and @value=\"3\"]")
                .click("//button[@type=\"submit\"]")
                .click("//button[@ng-click=\"deposit()\"]").pause(500)
                .click("//button[@ng-click=\"withdrawl()\"]").pause(500)
                .click("//button[@ng-click=\"transactions()\"]").pause(500)
                .click("//button[@ng-click=\"byebye()\"]").pause(1000)
        ;
        return this;
    }
}
