package baseEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        try {
            return driver.findElement(getPageIdentifier()).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }
}