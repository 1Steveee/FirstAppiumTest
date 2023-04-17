package org.FirstAppiumTest.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private WebElement successMessageCloseButton() {
        return driver.findElement(AppiumBy.id("android:id/button1"));
    }

    private WebElement loginTab() {
        return driver.findElement(AppiumBy.accessibilityId("button-login-container"));
    }
    private WebElement emailField() {
        return driver.findElement(AppiumBy.accessibilityId("input-email"));
    }

    private WebElement passwordField() {
        return driver.findElement(AppiumBy.accessibilityId("input-password"));
    }

    private WebElement loginButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-LOGIN"));
    }

    private WebElement successMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = driver.findElement(AppiumBy.id("android:id/message"));
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    public String getSuccessMessage() {
        return successMessage().getText();
    }




    public void Login(String email, String password) {
        loginTab().click();
        emailField().clear();
        emailField().sendKeys(email);
        passwordField().clear();
        passwordField().sendKeys(password);
        loginButton().click();
    }


    public void closeSuccessMessage() {
        successMessageCloseButton().click();
    }

    public String getSuccessMessageTitle() {
        return driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
    }
}
