package org.FirstAppiumTest;

import io.appium.java_client.AppiumDriver;
import org.FirstAppiumTest.Pages.HomePage;
import org.FirstAppiumTest.Pages.LoginPage;
import org.FirstAppiumTest.Pages.SignUpPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class AppiumTest extends BaseTest {

    private AppiumDriver driver;

    @BeforeClass
    public void setUpTest() {
        this.driver = driverManager.getDriver();
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
        assertEquals(loginPage.getSuccessMessageTitle(), "Success");
        assertEquals(loginPage.getSuccessMessage(), "You are logged in!");
    }
}
