package org.example.selenium.projects.school.website.orangehrmlive.entityProvider;

import org.example.selenium.projects.school.website.orangehrmlive.DTO.myInfo.PersonalDetails;

public class PersonalDetailsE {
    public static PersonalDetails person01 = new PersonalDetails()
            .setFirstName("Automation")
            .setMiddleName("STT nhóm")
            .setLastName("Ca học")
            .setNickName("Testing")
            .setEmployeeId("stt nhóm")
            .setOtherId("stt nhóm * 10")
            .setDriverLicenseNumber("11111")
            .setLicenseExpiryDate("2023-06-18")
            .setSsnNumber("300")
            .setSinNumber("")
            .setNationality("tự chọn")
            .setMaterialStatus("Single")
            .setGender("Female")
            .setMilitaryService("1")
            .setSmoker("no");
    public static PersonalDetails person02 = new PersonalDetails()
            .setFirstName("Huy")
            .setMiddleName("Đỗ")
            .setLastName("Ca Chiều")
            .setNickName("Testing")
            .setEmployeeId("Nhóm 11")
            .setOtherId("110")
            .setDriverLicenseNumber("11111")
            .setLicenseExpiryDate("2023-06-24")
            .setSsnNumber("300")
            .setSinNumber("")
            .setNationality("tự chọn")
            .setMaterialStatus("Single")
            .setGender("Male")
            .setMilitaryService("1")
            .setSmoker("no");

    public static PersonalDetails[] personalDetails = {person01, person02};
}
