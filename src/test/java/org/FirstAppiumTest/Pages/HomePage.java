package org.FirstAppiumTest.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    private WebElement swipeLink() {
        return driver.findElement(AppiumBy.accessibilityId("Swipe"));
    }

    public String getTitle () {
        return driver.findElement (AppiumBy.androidUIAutomator ("new UiSelector().text(\"WEBDRIVER\")"))
                .getText ();
    }

    public void openMenu(String menuName) {
        driver.findElement (AppiumBy.accessibilityId (menuName)).click ();

    }

    public String tagLine () {
        return driver.findElement (
                        AppiumBy.androidUIAutomator ("new UiSelector().text(\"Demo app for the appium-boilerplate\")"))
                .getText ();
    }

    public void openSwipePage() {
        swipeLink().click();
    }
}
