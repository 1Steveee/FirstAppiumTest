package org.FirstAppiumTest.ios;

import io.appium.java_client.ios.IOSDriver;

import org.FirstAppiumTest.ios.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AppiumTest extends BaseTest{

    private IOSDriver driver;

    @BeforeClass
    public void setUpTest() {
        this.driver = iosDriverManager.getDriver();
    }

    @Test
    public void testTitle() {
        HomePage homePage = new HomePage (this.driver);
        assertEquals (homePage.getTitle (), "WEBDRIVER");
    }

    @Test
    public void testSignUp() {
        SignUpPage signUpPage = new SignUpPage(this.driver);
        signUpPage.signUp("test123@email.com", "Pass12345");
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
    public void testFormsSignup()  {
        FormsPage formsPage = new FormsPage(driver);
        formsPage.fillForm("text1234", "This app is awesome");
        assertEquals("text1234",formsPage.getInputFieldText());
        assertEquals("Click to turn the switch OFF", formsPage.getSwitchFieldText());
        assertEquals("This app is awesome", formsPage.getDropdownText());
        formsPage.submitForm();
        assertEquals("This button is active", formsPage.getAlertMessageText());
        formsPage.closeAlert();
    }



    @Test
    public void testSwipe() {
        SwipePage swipePage = new SwipePage(driver);
        swipePage.swipeHorizontal();
        swipePage.swipeVertical();
    }

    @Test
    public void testSwipeAndFindElement() {
        SwipePage swipePage = new SwipePage(driver);
        assertEquals("You found me!!!",swipePage.swipeToElement());
    }

    @Test
    public void testWebViewPage() {
        WebViewPage webViewPage = new WebViewPage(driver);
        webViewPage.switchToWebView();
        assertEquals("Next-gen browser and mobile automation test framework for Node.js",
                webViewPage.getWebViewText());
    }

    @Test
    public void testDragAndDrop() {
        DragPage dragPage = new DragPage(driver);
        dragPage.dragAndDropPieces();
        assertEquals("Congratulations", dragPage.getCongratsMessage());

    }


}
