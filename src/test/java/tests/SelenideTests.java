package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tests.pages.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

//@Listeners({ SoftAsserts.class})
public class SelenideTests {
    static String url = "https://aqa1803.testrail.io/";
    String username = "atrostyanko@gmail.com";
    String password = "Americana#1";
    static Logger logger = Logger.getLogger(SelenideTests.class);

    @BeforeSuite
    public void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );

        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;
    }

    @BeforeMethod
    public void setup() {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();
        //static Logger logger = Logger.getLogger(FirstTest.class);

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Close the browser");
        closeWebDriver();
    }


    @Test
    public void userCanLogin() {
        // Настройка slf4j
/*
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
*/
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHaveSize(26)
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
    }

    @Test
    public void userCanLogin1() {
        // Начинаем писать тест
        open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(username);

        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHaveSize(26)
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
    }

    @Test
    public void test1() {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$(".chart-legend-name")
                .filter(visible)
                .shouldHave(
                        texts(
                                "MilestoneProject",
                                "asdasdasdfaszc",
                                "dfghj",
                                "erg"
                        )
                );

        Condition clickable = and("can be clicked", visible, enabled);
    }

    @Test
    public void test2() throws FileNotFoundException {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.downloadsFolder = "";
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(byText("asdasdasdfaszc")).shouldBe(visible);
        $(withText("dfghj")).shouldBe(visible);

        SelenideElement parent = $(byText("asdasdasdfaszc")).parent();
        System.out.println(parent.getTagName());

        $(byText("asdasdasdfaszc")).innerText();
        $(byText("asdasdasdfaszc")).innerHtml();
        $(byText("asdasdasdfaszc")).scrollTo();
        $(byText("asdasdasdfaszc")).closest("tr");
        $(byText("asdasdasdfaszc")).find(By.xpath(""));
        $(byText("asdasdasdfaszc")).doubleClick();
        $(byText("asdasdasdfaszc")).contextClick();
        $(byText("asdasdasdfaszc")).hover();

        //$(byText("asdasdasdfaszc")).uploadFile(new File(""));
        //$(byText("asdasdasdfaszc")).download();

        sleep(3000);
    }

}
