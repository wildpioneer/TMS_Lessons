package baseEntity;


import core.ReadProperties;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waits;

import java.util.NoSuchElementException;

public abstract class BasePage {
    protected WebDriver driver;
    protected String BASE_URL;
    protected Waits waits;

    public BasePage(WebDriver driver) {
        this(driver, false);
    }

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        this.waits = new Waits(driver);
        this.BASE_URL = ReadProperties.getUrl();

        if (openPageByUrl) {
            openPage();
        }
    }

    protected abstract void openPage();

    public boolean isPageOpened(By by) {
        return waits.waitForVisibility(by).isDisplayed();
    }
}