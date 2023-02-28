package org.FirstAppiumTest.Pages;

import io.appium.java_client.AppiumBy;

import static org.FirstAppiumTest.DriverManager.getDriver;

public class HomePage {

    public String getTitle () {
        return getDriver ().findElement (AppiumBy.androidUIAutomator ("new UiSelector().text(\"WEBDRIVER\")"))
                .getText ();
    }

    public void openMenu(String menuName) {
        getDriver ().findElement (AppiumBy.accessibilityId (menuName)).click ();

    }

    public String tagLine () {
        return getDriver ().findElement (
                        AppiumBy.androidUIAutomator ("new UiSelector().text(\"Demo app for the appium-boilerplate\")"))
                .getText ();
    }
}
