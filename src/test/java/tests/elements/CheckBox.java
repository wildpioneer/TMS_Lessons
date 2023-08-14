package tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public CheckBox(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }


    private void setFlag(boolean flag) {
        if (!uiElement.isSelected() && flag) {
            uiElement.click();
        }
    }

    public void set() {
        setFlag(true);
    }

    public void remove() {
        setFlag(false);
    }
}
