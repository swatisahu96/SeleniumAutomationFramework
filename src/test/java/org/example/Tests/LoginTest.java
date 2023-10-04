package org.example.Tests;

import basetest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.example.Driver.DriverManagerTL;
import org.example.Pages.DashboardPage;
import org.example.Pages.LoginPage;
import org.example.utils.propReader;
import org.example.utils.screenShotListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

@Listeners(screenShotListener.class)
public class LoginTest extends BaseTest {

    @Description("Positive Test- Login to VWO app")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void loginPositiveTest() throws Exception {
        DriverManagerTL.getDriver().get(propReader.readKey("url"));
        logger.info("Navigated to url");
        DashboardPage dashboardPage = new LoginPage().loginToAppVWO(false).afterLogin();
        logger.info("Navigated to Dashboard");
        String expectedUser = dashboardPage.loggedInUser();
        Assertions.assertThat(expectedUser).isNotNull().isNotBlank().contains(propReader.readKey("loggedInUser"));
    }

    @Description("Negative Test- Login to VWO app")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 0)

    public void loginNegativeTest(Method method) throws Exception {

        DriverManagerTL.getDriver().get(propReader.readKey("url"));
        String errorMessage = new LoginPage().loginToAppVWO(true).verifyErrorMessage();
        System.out.println("Error Message: "+errorMessage);
        if(propReader.readKey("expected_error").equalsIgnoreCase(errorMessage)){
           logger.info("Failed TestCase Passed!");
        }
        else{
            takeScreenshot(method.getName(),DriverManagerTL.getDriver() );
        }
        Assertions.assertThat(errorMessage).isNotBlank().isNotNull().contains(propReader.readKey("expected_error"));

    }
}

