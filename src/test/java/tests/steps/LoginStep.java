package tests.steps;

import org.openqa.selenium.WebDriver;
import tests.baseEntities.BaseStep;
import tests.models.User;
import tests.pages.DashboardPage;
import tests.pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successLogin(User user) {
        loginPage.login(user);

        return dashboardPage;
    }

    public LoginPage negativeLogin(User user) {
        loginPage.login(user);

        return loginPage;
    }
}
