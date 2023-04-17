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

    public void opensSwipePage() {
        HomePage homePage = new HomePage(driver);
        homePage.openMenu("Swipe");
    }

    public void swipeUpFullScreen() {
        opensSwipePage();
        helper.swipeFullPage();
        helper.swipeHalfPage();
    }

    public void swipeLeft(){
        opensSwipePage();
        helper.swipeLeft();
    }


}
