package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.baseEntities.BasePage;
import tests.elements.CheckBox;
import tests.elements.Input;
import tests.elements.RadioButton;
import tests.elements.UIElement;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/add";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Project')]");

    private final By nameInputLocator = By.id("name");
    private final By announcementTextAreaLocator = By.id("announcement_display");
    private final By showAnnouncementCheckBoxLocator = By.id("show_announcement");
    private final By typeRadioButtonLocator = By.name("suite_mode");

    // Блок инициализации
    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public UIElement getHeaderTitle() {
        return new UIElement(driver, headerTitleLabelLocator);
    }

    public Input getNameInput() {
        return new Input(driver, nameInputLocator);
    }

    public UIElement getAnnouncementTextArea() {
        return new UIElement(driver, announcementTextAreaLocator);
    }

    public CheckBox getShowAnnouncementCheckBox() {
        return new CheckBox(driver, showAnnouncementCheckBoxLocator);
    }

    public RadioButton getTypeRadioButton() {
        return new RadioButton(driver, typeRadioButtonLocator);
    }
}
