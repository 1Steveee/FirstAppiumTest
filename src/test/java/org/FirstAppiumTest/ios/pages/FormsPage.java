package org.FirstAppiumTest.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormsPage {

    private final IOSDriver driver;

    public FormsPage(IOSDriver driver) {
        this.driver = driver;
    }

    private WebElement textInputField() {
        return driver.findElement(AppiumBy.accessibilityId("text-input"));
    }

    private WebElement switchButton() {
        return driver.findElement(AppiumBy.accessibilityId("switch"));
    }

    private List<WebElement> dropdownList() {
        return driver.findElements(AppiumBy.className("XCUIElementTypePickerWheel"));
    }

    private WebElement dropdownMenu() {

        return driver.findElement(AppiumBy.accessibilityId("Dropdown"));
    }

    private WebElement findElement(String accessibilityID) {
        return driver.findElement(AppiumBy.accessibilityId(accessibilityID));
    }


    private WebElement activeButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-Active"));
    }

    private WebElement alertMessage() {
        return driver.findElement(AppiumBy.id("This button is active"));
    }


    public WebElement okButton () {
        return driver.findElement(AppiumBy.id("OK"));
    }

    private void navigateToFormsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openMenu("Forms");
    }

    public void fillForm(String inputField, int dropdownValue)  {
        navigateToFormsPage();
        textInputField().sendKeys(inputField);
        switchButton().click();
//        selectDropdownValue(dropdownValue);
    }

    private void selectDropdownValue(int dropdownValue) {
        dropdownMenu().click();
        dropdownList().get(dropdownValue).click();
    }

    public String getDropdownText() {
        return driver.findElement(AppiumBy
                .iOSClassChain
                        ("**/XCUIElementTypePickerWheel[`value == \"Select an item...\"`]" +
                                "/XCUIElementTypeOther[1]")).getText();
    }
    public String getInputFieldText() {
        return findElement("input-text-result").getText();
    }

    public String getSwitchFieldText() {
        return findElement("switch-text").getText();
    }

    public String getAlertMessageText() {
        return alertMessage().getText();
    }


    public void submitForm() {
        activeButton().click();
    }

    public void closeAlert() {
        okButton().click();
    }
}
