package org.example.selenium;

import net.bytebuddy.implementation.bytecode.Throw;
import org.example.selenium.utils.PrintColor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import java.util.function.Consumer;

public class TestAction {

    public WebDriver driver;
    public Properties properties;
    public String webUrl;

    public TestAction(WebDriver driver, String webUrl, Properties properties){
        this.driver = driver;
        this.webUrl = webUrl;
        this.properties = properties;
    }
    public TestAction get(String webUrl){
        this.driver.get(webUrl);
        return this;
    }
    public void quit(){
        this.driver.quit();
    }
    public TestAction pause(long millisecond) {
        try {
            Thread.sleep(millisecond);
        }catch (InterruptedException e){
            System.out.printf("Something went wrong when involve pause(%d)%n", millisecond);
            e.printStackTrace();
        }
        return this;
    }
    public WebElement checkExisting(String path){
        try {
            return this.driver.findElement(By.xpath(path));
        }catch (NoSuchElementException e){
            PrintColor.yellow(String.format("Could not find %s", path));
        }
        return null;
    }
    public TestAction sendKeys(String path, String value) {
        checkExisting(path).sendKeys(value);
        return this;
    }
    public TestAction click(String path){
        checkExisting(path).click();
        return this;
    }

    public TestAction getText(String path, Consumer<String> callback){
        callback.accept(checkExisting(path).getText());
        return this;
    }

    public TestAction clear(String path) {
        checkExisting(path).clear();
        return this;
    }
}