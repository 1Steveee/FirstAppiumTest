package org.FirstAppiumTest;

import io.appium.java_client.AppiumDriver;
import org.FirstAppiumTest.Pages.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class AppiumTest extends BaseTest {

    private AppiumDriver driver;
    private SwipePage swipePage;

    @BeforeClass
    public void setUpTest() {

        this.driver = driverManager.getDriver();
        this.swipePage = new SwipePage(driver);
    }

    @Test
    public void testTitle() {
        HomePage homePage = new HomePage (this.driver);
        assertEquals (homePage.getTitle (), "WEBDRIVER");
    }

    @Test
    public void testSignUp () {
        SignUpPage signUpPage = new SignUpPage (driver);
        signUpPage.signUp ("test123@email.com", "Pass12345");
        assertEquals (signUpPage.getSuccessMessageTitle (), "Signed Up!");
        assertEquals (signUpPage.getSuccessMessage (), "You successfully signed up!");
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("test123@gmail.com", "Pass12345");
        assertEquals(loginPage.getSuccessMessage(), "You are logged in!");
        loginPage.closeSuccessMessage();
    }

    @Test
    public void testSwipeLeft()  {
        this.swipePage.swipeLeft();
    }

    @Test
    public void testSwipeUp() {
        this.swipePage.swipeUpFullScreen();
    }

    @Test
    public void testFormsSignup()  {
        FormsPage formsPage = new FormsPage(driver);
        formsPage.fillForm("text1234", 3);
        assertEquals("text1234",formsPage.getInputFieldText());
        assertEquals("Click to turn the switch OFF", formsPage.getSwitchFieldText());
        assertEquals("This app is awesome", formsPage.getDropdownText());
        formsPage.submitForm();
        assertEquals("This button is active", formsPage.getAlertMessageText());
        formsPage.closeAlert();
    }
}
