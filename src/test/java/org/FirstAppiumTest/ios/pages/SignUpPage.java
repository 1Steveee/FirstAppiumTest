package org.FirstAppiumTest.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    private final IOSDriver driver;

    public SignUpPage(IOSDriver driver) {
        this.driver = driver;
    }

    private WebElement emailField () {
        return driver.findElement (AppiumBy.accessibilityId ("input-email"));
    }

    private WebElement signUpLink () {
        return driver.findElement (AppiumBy.accessibilityId ("button-sign-up-container"));
    }

    private WebElement passwordField () {
        return driver.findElement (AppiumBy.accessibilityId ("input-password"));
    }

    private WebElement confirmPasswordField () {
        return driver.findElement (AppiumBy.accessibilityId ("input-repeat-password"));
    }

    private WebElement signUpBtn () {
        return driver.findElement (AppiumBy.accessibilityId ("button-SIGN UP"));
    }

    private WebElement okSuccessMessageButton() {
        return driver.findElement(AppiumBy.accessibilityId("OK"));
    }
    private void dismissSuccessMessage() {
        okSuccessMessageButton().click();
    }

    public void signUp(String email, String password) {
        HomePage homePage = new HomePage(this.driver);
        homePage.openMenu("Login");
        signUpLink().click();
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        confirmPasswordField().sendKeys(password);
        signUpBtn().click();
    }


    public String getSuccessMessage () {
        String successMessage = driver.findElement (AppiumBy.accessibilityId ("You successfully signed up!")).getText ();
        dismissSuccessMessage();
        return successMessage;
    }

    public String getSuccessMessageTitle () {
        return driver.findElement(AppiumBy
                .iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Signed Up!\"`]")).getText();
    }
}
