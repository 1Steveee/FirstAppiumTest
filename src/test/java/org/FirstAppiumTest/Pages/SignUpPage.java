package org.FirstAppiumTest.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;


public class SignUpPage {

    private AppiumDriver driver;

    public SignUpPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private WebElement signUpLink () {
        return driver.findElement (AppiumBy.accessibilityId ("button-sign-up-container"));
    }

    private WebElement emailField () {
        return driver.findElement (AppiumBy.accessibilityId ("input-email"));
    }

    private WebElement okSuccessMessageButton() {
        return driver.findElement(AppiumBy.id("android:id/button1"));
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

    public String getSuccessMessageTitle () {
        return driver.findElement (AppiumBy.id ("android:id/alertTitle")).getText ();
    }

    public String getSuccessMessage () {
        return driver.findElement (AppiumBy.id ("android:id/message")).getText ();
    }


    public void signUp(String email, String password) {
        HomePage homePage = new HomePage (driver);
        homePage.openMenu ("Login");
        signUpLink ().click ();
        emailField ().sendKeys (email);
        passwordField ().sendKeys (password);
        confirmPasswordField ().sendKeys (password);
        signUpBtn ().click ();
    }

    public void dismissSuccessMessage() {
        okSuccessMessageButton().click();
    }
}
