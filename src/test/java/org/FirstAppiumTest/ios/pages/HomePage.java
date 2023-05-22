package org.FirstAppiumTest.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private final IOSDriver driver;

    public HomePage(IOSDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"WEBDRIVER\"`]")).getText();

    }

    public void openMenu(String menuName) {
        driver.findElement(AppiumBy.accessibilityId(menuName)).click();
    }
}
