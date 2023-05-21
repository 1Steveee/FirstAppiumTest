package org.FirstAppiumTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSDriverManager {

    private IOSDriver driver;
    private final String APP_PATH = System.getProperty ("user.home") + "/Downloads/wdioNativeDemoApp 2.app";
    private final String APPIUM_SERVER_URL = "http://localhost:4723/wd/hub";

    private XCUITestOptions xcuiTestOptions() {
        return new XCUITestOptions()
                .setPlatformName("iOS")
                .setPlatformVersion("16.2")
                .setDeviceName("iPhone 14")
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setApp(APP_PATH)
                .setNoReset(false);
    }

    public void createIOSDriver() throws MalformedURLException {
        driver = new IOSDriver(new URL(APPIUM_SERVER_URL), xcuiTestOptions());
        setUpDriverTimeOuts();
    }

    private void setUpDriverTimeOuts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void stopDriver() {
        driver.quit();
    }

    public IOSDriver getDriver() {
        return driver;
    }

}
