package org.FirstAppiumTest.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
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
        return driver.findElement(AppiumBy.id("android:id/message"));
    }

    public String getSuccessMessage() {
        return successMessage().getText();
    }

    public void clearLoginFormFields() {
        emailField().clear();
        passwordField().clear();
    }


    public void Login(String email, String password) {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.dismissSuccessMessage();
        loginTab().click();
        clearLoginFormFields();
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        loginButton().click();
    }

    public String getSuccessMessageTitle() {
        return driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
    }
}
