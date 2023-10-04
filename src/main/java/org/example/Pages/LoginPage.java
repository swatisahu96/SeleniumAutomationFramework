package org.example.Pages;

import org.example.Base.basePage;
import org.example.utils.propReader;
import org.openqa.selenium.By;

public class LoginPage extends basePage {


    public LoginPage() {
        super();
    }

    static By userName = By.id("login-username");
    static By password = By.id("login-password");
    static By signInButton = By.id("js-login-btn");
    static By errorMessage = By.id("js-notification-box-msg");


    public LoginPage loginToAppVWO(boolean invalid) throws Exception {

        implicitWait();
        if (!invalid) {
            enterInput(userName, propReader.readKey("validUserName"));
        } else {
            enterInput(userName, propReader.readKey("inValidUserName"));
        }
        enterInput(password, propReader.readKey("password"));
        clickElement(signInButton);

        return this;//For using chaining concept
    }

    public static DashboardPage afterLogin() {
        return new DashboardPage();
    }

    public String verifyErrorMessage() {
        visibilityOfElement(errorMessage);
        return getElement(errorMessage).getText();
    }

}
