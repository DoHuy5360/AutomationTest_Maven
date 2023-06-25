package org.example.selenium.projects.school.exercises;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import org.example.selenium.projects.school.website.orangehrmlive.DTO.myInfo.PersonalDetails;
import org.example.selenium.projects.school.website.orangehrmlive.XpathElement;
import org.example.selenium.projects.school.website.orangehrmlive.entityProvider.PersonalDetailsE;
import org.example.selenium.setup.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;


public class Exercise03 extends XpathElement {
    public static String webUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public Exercise03() {
        this.driver = new Driver().useChrome();
        PageFactory.initElements(this.driver, this);
    }
    public String result;
    @BeforeEach
    public void beforeTest() {
        driver.get(webUrl);
    }
    @ParameterizedTest
    @MethodSource("objectProvider")
    public void test(PersonalDetails personalDetails) {
        sendKeys(loginUserName, "Admin", true)
                .sendKeys(loginUserPassword, "admin123", true)
                .click(loginSubmitForm, true)
                .click(sidebarMyInfo, true)
                .pause(2000)
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
    }

    private static Stream<Arguments> objectProvider() {
        return Arrays.stream(PersonalDetailsE.getPersonalDetails()).map(Arguments::of);
    }
    @AfterEach
    public void afterTest() throws InterruptedException {
        quit();
    }

}
