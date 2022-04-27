package baseEntity;

import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract By getPageIdentifier();

    protected void navigateByUrl(String path) {
        driver.get(ReadProperties.getURL() + path);
    }

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }
}