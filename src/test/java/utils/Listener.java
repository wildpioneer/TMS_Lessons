package utils;

import baseEntities.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class Listener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext iTestContext = result.getTestContext();
        WebDriver driver = (WebDriver) iTestContext.getAttribute("WebDriver");

        try {
            Allure.addAttachment(UUID.randomUUID().toString(),
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (NoSuchSessionException ex) {

        }
    }
}
