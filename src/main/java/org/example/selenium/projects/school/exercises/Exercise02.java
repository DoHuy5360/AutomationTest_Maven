package org.example.selenium.projects.school.exercises;

import org.example.selenium.projects.school.website.orangehrmlive.models.XpathElement;
import org.example.selenium.projects.school.website.orangehrmlive.models.myInfo.PersonalDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;
import java.util.Properties;

public class Exercise02 extends XpathElement {
    public Exercise02(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
        PageFactory.initElements(driver, this);
    }
    public Exercise02(WebDriver driver, String webUrl) {
        super(driver, webUrl);
        PageFactory.initElements(driver, this);
    }

    public Exercise02 login(){
        get(webUrl)
                .sendKeys(loginUserName, "Admin", true)
                .sendKeys(loginUserPassword, "admin123", true)
                .click(loginSubmitForm, true)
        ;
        return this;
    }
    public Exercise02 updateMyInfo(PersonalDetails personalDetails) {
        click(sidebarMyInfo, true).pause(2000)
                .clearThenSendKeys(personalDetailFirstNameInput, personalDetails.getFirstName(), true)
                .clearThenSendKeys(personalDetailMiddleNameInput, personalDetails.getMiddleName(), true)
                .clearThenSendKeys(personalDetailLastNameInput, personalDetails.getLastName(), true)
                .clearThenSendKeys(personalDetailNickNameInput, personalDetails.getNickName(), true)
                .clearThenSendKeys(personalDetailEmployeeIdInput, personalDetails.getEmployeeId(), true)
                .clearThenSendKeys(personalDetailOtherIdInput, personalDetails.getOtherId(), true)
                .clearThenSendKeys(personalDetailDriverLicenseNumberInput, personalDetails.getDriverLicenseNumber(), true)
                .clearThenSendKeys(personalDetailLicenseExpiryDateInput, personalDetails.getLicenseExpiryDate(), true)
                .clearThenSendKeys(personalDetailSsnNumberInput, personalDetails.getSsnNumber(), true)
                .click(personalDetailNationalityInput, true).pause(500)
                .click(personalDetailNationalityOption01, true)
                .click(personalDetailMaterialStatusInput, true).pause(500)
                .click(personalDetailMaterialStatusOptionSingle, true).pause(500)
                .click(Objects.equals(personalDetails.getGender(), "Female") ?  personalDetailFemaleInput: personalDetailMaleInput, true)
                .unCheck(personalDetailSmokeInput, personalDetailSmokeLabel, false)
                .click(userTopRightDropdown, true)
                .click(userTopRightDropdownLogout, true)

        ;
        return this;
    }
}
