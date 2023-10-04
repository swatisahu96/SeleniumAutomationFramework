package basetest;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Driver.DriverManagerTL;
import org.example.Tests.LoginTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected static Logger logger;

    @BeforeMethod
    protected void setUp() {
        DriverManagerTL.init();
        logger = LogManager.getLogger(LoginTest.class);
    }

    @AfterMethod
    protected void tearDown() {
        DriverManagerTL.down();
    }

    //On demand screenshot
    protected void takeScreenshot(String name, WebDriver driver) throws IOException {
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
    }


}
