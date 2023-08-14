package tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.baseEntities.BaseTest;
import tests.helper.DataHelper;
import tests.models.User;
import tests.pages.AddTestCasePage;
import utils.configuration.ReadProperties;

public class AddProjectTest extends BaseTest {

    @Test
    public void successLoginTest() {
        loginStep.successLogin(DataHelper.getAdminUser());
        projectStep.AddProject(DataHelper.getProject());

        driver.get("https://aqa21onl02.testrail.io/index.php?/cases/add/2");
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver);
        addTestCasePage.getTemplateDropDown().selectByText("Exploratory Session");
    }
}
