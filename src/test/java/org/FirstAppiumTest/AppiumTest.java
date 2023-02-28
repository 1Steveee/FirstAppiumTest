package org.FirstAppiumTest;

import org.FirstAppiumTest.Pages.HomePage;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class AppiumTest extends BaseTest {
    @Test
    public void testTitle() {
        HomePage homePage = new HomePage();
        assertEquals (homePage.getTitle(), "WEBDRIVER");
        assertEquals(homePage.tagLine(),"Demo app for the appium-boilerplate");
        System.out.println("Application is successfully set up");
    }

}
