package org.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    public WebElement loginUserName;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    public WebElement loginUserPassword;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement loginSubmitForm;
    // *------
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")
    public WebElement sidebarMyInfo;
    @FindBy(how = How.XPATH, using = "//input[@name='firstName']")
    public WebElement personalDetailFirstNameInput;
    @FindBy(how = How.XPATH, using = "//input[@name='middleName']")
    public WebElement personalDetailMiddleNameInput;
    @FindBy(how = How.XPATH, using = "//input[@name='lastName']")
    public WebElement personalDetailLastNameInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input")
    public WebElement personalDetailNickNameInput;

    public WebDriver driver;

    public Page() {
        WebDriverManager webDriver = WebDriverManager.chromedriver();
        webDriver.setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        PageFactory.initElements(driver, this);
    }

    public WebElement find(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(ele));
        // wait.until(ExpectedConditions.elementToBeClickable(ele));
        return ele;
    }

    public void clear(WebElement ele) {
        ele.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }

    public void sleep(int second) {
        try {

            Thread.sleep(second);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void accessWebPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void login() {
        WebElement _loginUserName = find(loginUserName);
        _loginUserName.sendKeys("Admin");
        WebElement _loginUserPassword = find(loginUserPassword);
        _loginUserPassword.sendKeys("admin123");
        WebElement _loginSubmitForm = find(loginSubmitForm);
        _loginSubmitForm.click();
    }

    public void accessMyinfoPage() {
        WebElement _sidebarMyInfo = find(sidebarMyInfo);
        _sidebarMyInfo.click();
    }

    public void fillNames() {
        sleep(1500);

        WebElement _personalDetailFirstNameInput = find(personalDetailFirstNameInput);
        clear(_personalDetailFirstNameInput);
        _personalDetailFirstNameInput.sendKeys("Huy");

        sleep(500);

        try {
            assertEquals(_personalDetailFirstNameInput.getAttribute("value"), "Minh");
        } catch (Exception e) {
            System.out.println("Mong doi gia tri laf Minh");
        }

        WebElement _personalDetailMiddleNameInput = find(personalDetailMiddleNameInput);
        clear(_personalDetailMiddleNameInput);
        _personalDetailMiddleNameInput.sendKeys("Huy");

        WebElement _personalDetailLastNameInput = find(personalDetailLastNameInput);
        clear(_personalDetailLastNameInput);
        _personalDetailLastNameInput.sendKeys("Huy");

        WebElement _personalDetailNickNameInput = find(personalDetailNickNameInput);
        clear(_personalDetailNickNameInput);
        _personalDetailNickNameInput.sendKeys("Huy");

    }

}
