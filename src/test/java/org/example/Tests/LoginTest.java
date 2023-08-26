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
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Description("Positive Test- Login to VWO app")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginPositiveTest() throws Exception {
        DriverManagerTL.getDriver().get(propReader.readKey("url"));
        DashboardPage dashboardPage = new LoginPage().loginToAppVWO(false).afterLogin();
        String expectedUser = dashboardPage.loggedInUser();
        Assertions.assertThat(expectedUser).isNotNull().isNotBlank().contains(propReader.readKey("loggedInUser"));

    }

    @Description("Negative Test- Login to VWO app")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginNegativeveTest() throws Exception {
        DriverManagerTL.getDriver().get(propReader.readKey("url"));
        String errorMessage = new LoginPage().loginToAppVWO(true).verifyErrorMessage();

        Assertions.assertThat(errorMessage).isNotBlank().isNotNull().contains(propReader.readKey("expected_error"));
    }

}

