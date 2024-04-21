package tests.baseEntities;

import configuration.ReadProperties;
import core.BrowserService;
import core.WaitsService;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tests.utils.InvokedListener;

//@Listeners(Listener.class)
@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new BrowserService().getDriver();
        this.setDriverToContext(iTestContext, driver);
        waitsService = new WaitsService(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }

    public static WebDriver getDriverFromContext(ITestContext iTestContext){
        return (WebDriver) iTestContext.getAttribute("WebDriver") ;
    }
}
