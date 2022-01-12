package tests;

import baseEntity.BaseTest;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import sun.rmi.runtime.Log;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        Assert.assertTrue(new LoginPage(driver)
                .successLogin(ReadProperties.getUsername(), ReadProperties.getPassword())
                .getAddProjectButton().isDisplayed());
    }

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
}
