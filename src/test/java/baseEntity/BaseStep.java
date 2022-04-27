package baseEntity;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class BaseStep {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }
}
