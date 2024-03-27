package tests;

import baseEntity.BaseTest;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage
                        .successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );
    }

    @Test
    public void wrongEmailLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(
                loginPage
                        .incorrectLogin("sdsads", ReadProperties.password())
                        .getErrorText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}
