package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.LoginStep;
import steps.NavigationStep;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;

    @BeforeMethod
    public void setup(ITestContext context) {
        driver = new BrowsersService().getDriver();
        context.setAttribute("driver", driver);

        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
