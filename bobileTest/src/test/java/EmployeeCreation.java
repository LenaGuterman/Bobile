import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class EmployeeCreation extends ApplicationManager {

    @Test
    public void EmployeeCreation() {
        login("lenacrossfit@bobile.com", "qwerty");
        clickOnManageBtn();
        openCalendarModule();
        openTabEmployees();
        clickOnAddNewEmployee();
        fillingNewEmployeeForm("Employee 1", "employee@test.com");
    }

}
