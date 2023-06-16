package org.example.selenium.projects.school.web;

import org.example.selenium.TestAction;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Omayo extends TestAction {
    public Omayo(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }
    public Omayo(WebDriver driver, String webUrl) {
        super(driver, webUrl);
    }
    public Omayo downloadFile() {
        get(this.webUrl)
                .click("//a[text()=\"ZIP file\"]").pause(5000);
        return this;
    }

}
