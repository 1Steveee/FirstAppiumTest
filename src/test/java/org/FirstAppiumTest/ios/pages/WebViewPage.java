package org.FirstAppiumTest.ios.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebViewPage {

    private final IOSDriver driver;

    public WebViewPage(IOSDriver driver) {
        this.driver = driver;
        HomePage homePage = new HomePage(driver);
        homePage.openMenu("Webview");
    }


    public void switchToWebView() {
        // Switching to webview
        Set<String> contextNames = driver.getContextHandles();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Steven"));
        wait.until((d) -> contextNames.size() > 1);
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_<APP_PKG_NAME>
    }

    public String getWebViewText() {
        return driver.findElement(By.cssSelector("header > div > p")).getText();
    }


}
