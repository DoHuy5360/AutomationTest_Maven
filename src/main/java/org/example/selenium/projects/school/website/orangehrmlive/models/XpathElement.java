package org.example.selenium.projects.school.website.orangehrmlive.models;

import org.example.selenium.TestAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Properties;

public class XpathElement extends TestAction {
    public XpathElement(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }
    public XpathElement(WebDriver driver, String webUrl) {
        super(driver, webUrl);
    }
    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    public WebElement loginUserName;
    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    public WebElement loginUserPassword;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement loginSubmitForm;
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
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")
    public WebElement personalDetailEmployeeIdInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input")
    public WebElement personalDetailOtherIdInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input")
    public WebElement personalDetailDriverLicenseNumberInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input")
    public WebElement personalDetailLicenseExpiryDateInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input")
    public WebElement personalDetailSsnNumberInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input")
    public WebElement personalDetailSinNumberInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]")
    public WebElement personalDetailNationalityInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div[2]/div[2]")
    public WebElement personalDetailNationalityOption01;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]")
    public WebElement personalDetailMaterialStatusInput;
    @FindBy(how = How.XPATH, using = "(//div[@class='oxd-select-text oxd-select-text--focus'])/../div[@role='listbox']/div[2]")
    public WebElement personalDetailMaterialStatusOptionSingle;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/label")
    public WebElement personalDetailMaleInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label")
    public WebElement personalDetailFemaleInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[2]/div/div[2]/div/label/input")
    public WebElement personalDetailSmokeInput;
    @FindBy(how = How.XPATH, using = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[2]/div/div[2]/div/label/span")
    public WebElement personalDetailSmokeLabel;
}
