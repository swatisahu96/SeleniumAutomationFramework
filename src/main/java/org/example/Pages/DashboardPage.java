package org.example.Pages;

import org.example.Base.basePage;
import org.openqa.selenium.By;

public class DashboardPage extends basePage {

    public DashboardPage() {

    }

    public By verifyUser = By.xpath("//span[@data-qa=\"lufexuloga\"]");


    public String loggedInUser() {

        return getElement(verifyUser).getText();

    }


}
