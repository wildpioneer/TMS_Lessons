package baseEntity;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    @BeforeMethod
    public void openPage() {
        driver = new BrowsersService().getDriver();
        driver.get(ReadProperties.getURL());

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @AfterMethod
    public void closePage() {
        driver.quit();
    }
}