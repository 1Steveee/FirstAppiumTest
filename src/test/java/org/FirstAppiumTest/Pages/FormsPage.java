package org.FirstAppiumTest.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FormsPage {

    private AppiumDriver driver;

    public FormsPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private WebElement findElement(String accessibilityID) {
        return driver.findElement(AppiumBy.accessibilityId(accessibilityID));
    }

    private WebElement textInputField() {
        return driver.findElement(AppiumBy.accessibilityId("text-input"));
    }

    private WebElement switchButton() {
        return driver.findElement(AppiumBy.accessibilityId("switch"));
    }

    private List<WebElement> dropdownList() {
        return driver.findElements(AppiumBy.id("android:id/text1"));
    }

    private WebElement dropdownMenu() {

        return driver.findElement(AppiumBy.accessibilityId("Dropdown"));
    }

    private WebElement activeButton() {
        return driver.findElement(AppiumBy.accessibilityId("button-Active"));
    }

    private WebElement alertMessage() {
        return driver.findElement(AppiumBy.id("android:id/message"));
    }


    public WebElement okButton () {
        return driver.findElement(AppiumBy.id("android:id/button1"));
    }

    private void navigateToFormsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openMenu("Forms");
    }

    public void fillForm(String inputField, int dropdownValue)  {
        navigateToFormsPage();
        textInputField().sendKeys(inputField);
        switchButton().click();
        selectDropdownValue(dropdownValue);
    }

    private void selectDropdownValue(int dropdownValue) {
        dropdownMenu().click();
        dropdownList().get(dropdownValue).click();
    }

    public String getDropdownText() {
        return driver.findElements(AppiumBy.className("android.widget.EditText")).get(1).getText();
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
