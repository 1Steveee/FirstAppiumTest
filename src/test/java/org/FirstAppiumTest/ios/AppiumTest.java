package org.FirstAppiumTest.ios;

import io.appium.java_client.ios.IOSDriver;
import org.FirstAppiumTest.IOSDriverManager;
import org.FirstAppiumTest.ios.pages.HomePage;
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
        System.out.println(homePage.getTitle());
        assertEquals (homePage.getTitle (), "WEBDRIVER");
    }
}
