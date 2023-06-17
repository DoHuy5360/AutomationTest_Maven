package org.example.selenium.projects.school.web;

import org.example.selenium.TestAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class Omayo extends TestAction {
    public Omayo(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }

    public Omayo(WebDriver driver, String webUrl) {
        super(driver, webUrl);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[text()=\"ZIP file\"]")
    public WebElement zipA;

    public Omayo downloadFile() {
        get(this.webUrl)
                .click(zipA).pause(5000);
        return this;
    }
}
