package org.FirstAppiumTest.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private IOSDriver driver;
    private WebDriverWait wait;

    public HomePage(IOSDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"WEBDRIVER\"`]"))).getText();
    }
}
