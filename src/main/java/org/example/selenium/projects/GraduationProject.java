package org.example.selenium.projects;

import org.example.selenium.TestAction;
import org.example.selenium.setup.Driver;
import org.example.selenium.setup.PropertiesFile;
import org.example.selenium.utils.PrintColor;
import org.openqa.selenium.WebDriver;


import java.util.Properties;

public class GraduationProject extends TestAction{
    static String webUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    static Properties properties = new PropertiesFile("config.properties").read();
    static String userName = properties.getProperty("graduation.name");
    static String userPassword = properties.getProperty("graduation.password");

    public GraduationProject(WebDriver driver, String webUrl, Properties properties) {
        super(driver, webUrl, properties);
    }
    public static void main(String[] args) {
        new Driver().useEdge().execute((driver)-> new GraduationProject(driver, webUrl, properties)
                .login(userName, userPassword)
                .sidebar()
                .timeAtWork()
                .myActions()
                .quickLaunch()
                .myInfo()
                .quit()
        );
    }
    public GraduationProject login(String userName, String userPassword) {
        PrintColor.green("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        try {
            get(webUrl)
                    .sendKeys("//input[@name='username']", userName)
                    .sendKeys("//input[@name='password']", userPassword)
                    .pause(500)
                    .click("//button[@type='submit']");
        } catch (Exception e){
            e.printStackTrace();
            PrintColor.red("Unexpected errors have appeared in login() steps.");
            quit();
        }
        PrintColor.yellow("login() passed!");
        return this;
    }
    public GraduationProject sidebar() {
        PrintColor.green("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        String adminView = "//span[text()=\"Admin\"]";
        String pimView = "//span[text()=\"PIM\"]";
        String leaveView = "//span[text()=\"Leave\"]";
        String timeView = "//span[text()=\"Time\"]";
        String recruitmentView = "//span[text()=\"Recruitment\"]";
        String myInfoView = "//span[text()=\"My Info\"]";
        String performanceView = "//span[text()=\"Performance\"]";
        String directoryView = "//span[text()=\"Directory\"]";
        String dashboardView = "//span[text()=\"Dashboard\"]";
        String maintenanceView = "//span[text()=\"Maintenance\"]";
        String buzzView = "//span[text()=\"Buzz\"]";
        try {
            click(adminView)
                    .click(pimView).pause(500)
                    .click(leaveView).pause(500)
                    .click(timeView).pause(500)
                    .click(recruitmentView).pause(500)
                    .click(myInfoView).pause(500)
                    .click(performanceView).pause(500)
                    .click(directoryView).pause(500)
                    .click(maintenanceView).pause(500)
                    .click("//button[text()=\" Cancel \"]")
    //                .click("//button[@type=\"submit\"]")
                    .click(buzzView).pause(500)
                    .click(dashboardView).pause(500);
        } catch (Exception e){
            e.printStackTrace();
            PrintColor.red("Unexpected errors have appeared in sidebar() steps.");
            quit();
        }
        PrintColor.yellow("sidebar() passed!");
        return this;
    }
    public GraduationProject timeAtWork() {
        PrintColor.green("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        getText("//div[@class=\"orangehrm-attendance-card-profile-record\"]/p[1]", PrintColor::turquoise)
                .getText("//div[@class=\"orangehrm-attendance-card-profile-record\"]/p[2]", PrintColor::turquoise);
        return this;
    }
    public GraduationProject myActions() {
        PrintColor.green("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        getText("//button[@class=\"oxd-icon-button oxd-icon-button--success orangehrm-report-icon\"]/../p", PrintColor::turquoise)
                .getText("//button[@class=\"oxd-icon-button oxd-icon-button--warn orangehrm-report-icon\"]/../p", PrintColor::turquoise)
                .getText("//button[@class=\"oxd-icon-button oxd-icon-button--danger orangehrm-report-icon\"]/../p", PrintColor::turquoise)
                .getText("//button[@class=\"oxd-icon-button oxd-icon-button--info orangehrm-report-icon\"]/../p", PrintColor::turquoise);
        return this;
    }
    public GraduationProject quickLaunch(){
        PrintColor.green("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        getText("//div[@title=\"Assign Leave\"]/p",PrintColor::turquoise)
                .getText("//div[@title=\"Leave List\"]/p",PrintColor::turquoise)
                .getText("//div[@title=\"Timesheets\"]/p",PrintColor::turquoise)
                .getText("//div[@title=\"Apply Leave\"]/p",PrintColor::turquoise)
                .getText("//div[@title=\"My Leave\"]/p",PrintColor::turquoise)
                .getText("//div[@title=\"My Timesheet\"]/p",PrintColor::turquoise)
        ;
        return this;
    }

    public GraduationProject myInfo() {
        String myInfoView = "//span[text()=\"My Info\"]";
        String personalDetailA = "//a[text()=\"Personal Details\"]";
        String contactDetailA = "//a[text()=\"Contact Details\"]";
        String emergencyContactA = "//a[text()=\"Emergency Contacts\"]";
        String dependentsA = "//a[text()=\"Dependents\"]";
        String immigrationA = "//a[text()=\"Immigration\"]";
        String jobA = "//a[text()=\"Job\"]";
        String salaryA = "//a[text()=\"Salary\"]";
        String taxExemptionsA = "//a[text()=\"Tax Exemptions\"]";
        String reportToA = "//a[text()=\"Report-to\"]";
        String qualificationsA = "//a[text()=\"Qualifications\"]";
        String membershipsA = "//a[text()=\"Memberships\"]";

        click(myInfoView).pause(2000)
                .click(contactDetailA).pause(500)
                .click(emergencyContactA).pause(500)
                .click(dependentsA).pause(500)
                .click(immigrationA).pause(500)
                .click(jobA).pause(500)
                .click(salaryA).pause(500)
                .click(taxExemptionsA).pause(500)
                .click(reportToA).pause(500)
                .click(qualificationsA).pause(500)
                .click(membershipsA).pause(500)
                .click(personalDetailA).pause(500)
                // License Expiry Date
                .click("(//input[@placeholder=\"yyyy-mm-dd\"])[1]").pause(500)
                .click("(//input[@placeholder=\"yyyy-mm-dd\"])[1]").pause(500)
                //Marital Status
                .click("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]").pause(500)
                .click("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div[2]/div[2]").pause(500)
                // Marital Status
                .click("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[2]").pause(500)
                .click("(//div[@class=\"oxd-select-text oxd-select-text--focus\"])/../div[@role=\"listbox\"]/div[2]").pause(500)
                // Date of Birth
                .click("(//input[@placeholder=\"yyyy-mm-dd\"])[2]").pause(500)
                .click("(//input[@placeholder=\"yyyy-mm-dd\"])[2]").pause(500)
        ;

        return this;
    }
}