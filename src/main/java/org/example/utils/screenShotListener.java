package org.example.utils;

import io.qameta.allure.Allure;
import org.example.Driver.DriverManagerTL;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class screenShotListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        Allure.addAttachment(result.getTestName(), new ByteArrayInputStream(((TakesScreenshot) DriverManagerTL.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
