package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        WebDriverManager webDriverManager = WebDriverManager.chromedriver();
        webDriverManager.setup();
        EdgeOptions options = new EdgeOptions();

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://google.com");
    }

}