import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void fillingNewEmployeeForm(String employeeName, String emplyeeEmail) {
        wd.findElement(By.id("employeeName")).click();
        wd.findElement(By.id("employeeName")).clear();
        wd.findElement(By.id("employeeName")).sendKeys(employeeName);
        wd.findElement(By.id("employeeEmail")).click();
        wd.findElement(By.id("employeeEmail")).clear();
        wd.findElement(By.id("employeeEmail")).sendKeys(emplyeeEmail);
        wd.findElement(By.xpath("//div[@id='addEmployee']//span[.='Save']")).click();
    }

    public void clickOnAddNewEmployee() {
        wd.findElement(By.cssSelector("path.icon-plus-back")).click();
    }

    public void openTabEmployees() {
        wd.findElement(By.xpath("//ul[@id='navigationTabs']//p[.='Employees']")).click();
    }

    public void openCalendarModule() {
        //wd.findElement(By.linkText("calendar\n                        \n                        \n                    \n                \n                Booking")).click();
        wd.findElement(By.xpath("//div[@data-pt-name='calendar']")).click();
    }

    public void clickOnManageBtn() {
        wd.findElement(By.cssSelector("span.manage-app")).click();
    }

    public void login(String login, String password) {
        openSite();
        wd.findElement(By.linkText("LOG IN")).click();
        wd.findElement(By.id("username")).click();
        wd.findElement(By.id("username")).clear();
        wd.findElement(By.id("username")).sendKeys(login);
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys(password);
        wd.findElement(By.id("login")).click();
    }

    public void openSite() {
        wd.get("http://bobile.com/");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
