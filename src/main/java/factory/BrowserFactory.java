package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.configuration.ReadProperties;

import java.time.Duration;

public class BrowserFactory {
    Logger logger = LogManager.getLogger(BrowserFactory.class);

    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public BrowserFactory() {
        switch (ReadProperties.browserName().toLowerCase()) {
            case "chrome" :
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).clearDriverCache().setup();
                //WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();

                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            default:
                logger.error("Browser " + ReadProperties.browserName() + " is not supported.");
                break;
        }
    }

    public WebDriver getDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        return this.driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--headless=new");

        return chromeOptions;
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.setHeadless(false);
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--silent");
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--incognito");

        return firefoxOptions;
    }
}
