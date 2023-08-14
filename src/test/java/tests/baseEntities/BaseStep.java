package tests.baseEntities;


import org.openqa.selenium.WebDriver;
import tests.pages.AddProjectPage;
import tests.pages.DashboardPage;
import tests.pages.LoginPage;

public class BaseStep {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AddProjectPage addProjectPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
    }
}
