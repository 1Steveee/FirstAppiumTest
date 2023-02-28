package org.FirstAppiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import java.time.Duration;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {

    private static AppiumDriver driver;
    private static final String APP_PATH = "C:\\Users\\steve\\Downloads\\Android-NativeDemoApp-0.4.0.apk";
    private static final String APPIUM_SERVER_URL = "http://0.0.0.0:4723/wd/hub";

    private static UiAutomator2Options uiAutomator2Options () {

        UiAutomator2Options uiAutomator2Options;
        uiAutomator2Options = new UiAutomator2Options ()
                .setDeviceName ("Pixel 6 Pro API 30")
                .setAutomationName (AutomationName.ANDROID_UIAUTOMATOR2)
                .setAvdLaunchTimeout (Duration.ofSeconds (300))
                .setAvdReadyTimeout (Duration.ofSeconds (100))
                .setApp (APP_PATH)
                .setAppPackage ("com.wdiodemoapp")
                .setAppActivity ("com.wdiodemoapp.MainActivity")
                .setNoReset (false)
                .setPlatformName("Android");
        return uiAutomator2Options;
    }

    public static void createAndroidDriver () throws MalformedURLException {
        driver = new AndroidDriver (new URL(APPIUM_SERVER_URL),uiAutomator2Options ());
        setupDriverTimeouts();
    }

    public static void stopDriver() {
        driver.quit();
    }

    public static <D extends AppiumDriver> D getDriver () {
        return (D) driver;
    }

    private static void setupDriverTimeouts () {
        driver.manage ()
                .timeouts ()
                .implicitlyWait (Duration.ofSeconds (30));
    }

    public void testname() {
        System.out.println("testing");
    }
}
