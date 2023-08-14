package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.baseEntities.BasePage;
import tests.elements.*;

public class AddTestCasePage extends BasePage {
    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Test Case')]");

    private final By templateDropDownLocator = By.id("template_id_chzn");

    // Блок инициализации
    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    // Блок атомарных методов
    public UIElement getHeaderTitle() {
        return new UIElement(driver, headerTitleLabelLocator);
    }

    public DropDown getTemplateDropDown() {
        return new DropDown(driver, templateDropDownLocator);
    }
}
