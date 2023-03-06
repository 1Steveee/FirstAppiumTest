package org.FirstAppiumTest.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.FirstAppiumTest.Utilities.Helper;


public class SwipePage {

    private AppiumDriver driver;
    private Helper helper;

    public SwipePage(AppiumDriver driver) {
        this.driver = driver;
        this.helper = new Helper(driver);
    }

    public void opensSwipePage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.closeSuccessMessage();
        HomePage homePage = new HomePage(driver);
        homePage.openSwipePage();
    }

    public void swipeUpFullScreen() throws InterruptedException {
        Thread.sleep(3000);
        helper.swipeFullPage();
        helper.swipeHalfPage();
    }

    public void swipeLeft() throws InterruptedException{
        opensSwipePage();
        Thread.sleep(3000);
        helper.swipeLeft();
    }


}
