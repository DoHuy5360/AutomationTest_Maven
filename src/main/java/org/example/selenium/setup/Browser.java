package org.example.selenium.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.function.Consumer;

public class Browser{
    static WebDriver driver;

    public void execute(Consumer<WebDriver> callback){
        callback.accept(driver);
    }
    public Browser useEdge(){
        WebDriverManager webDriverManager = WebDriverManager.edgedriver();
        webDriverManager.setup();
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--start-maximized");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--ignore-certificate-errors");
//        options.setAcceptInsecureCerts(true);
//        options.setHeadless(true);

        driver = new EdgeDriver(options);
//        WebDriver driver = new ChromeDriver(options);

        return this;

    }

}