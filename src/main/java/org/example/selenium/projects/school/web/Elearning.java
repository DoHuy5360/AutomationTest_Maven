package org.example.selenium.projects.school.web;

import org.example.selenium.TestAction;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Elearning extends TestAction {

    public Elearning(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }

    public Elearning login() {
        get(this.webUrl)
                .click("//span[@class=\"login\"]/a")
                .click("//div[@class=\"modal-content\"]//a")
        ;
        return this;
    }
    public Elearning openDashboard() {
                click("//div[@data-region=\"drawer-toggle\"]")
                        .click("//a[@data-key=\"myhome\"]")
//                        .click("//div[@data-region=\"drawer-toggle\"]")
                        .click("//span[text()=\"Kiểm thử tự động - 223_DIT0280_01\"]")
                        .addCSS("//body[@id=\"page-course-view-topics\"]","scrollBehavior","smooth").pause(500)
                        .addCSS("//div[@id=\"page-wrapper\"]","scrollPaddingTop","300px")
                        .scrollTo("//span[text()=\"Chương 5: Web locator\"]")
                        .highlight("//span[text()=\"Xpath Axes\"]")
                        .click("//span[text()=\"Xpath Axes\"]")
                ;

        return this;
    }

}
