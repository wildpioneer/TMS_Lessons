package steps;

import baseEntity.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends BaseStep {
    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successLogin(String email, String psw) {
        login(email, psw);

        return dashboardPage;
    }

    public LoginPage incorrectLogin(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    private void login(String email, String psw) {
        loginPage.getEmailField().sendKeys(email);
        loginPage.getPasswordField().sendKeys(email);
        loginPage.getLoginButton().click();
    }
}
