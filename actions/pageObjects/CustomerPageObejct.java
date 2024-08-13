package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerPageUI;

public class CustomerPageObejct extends BasePage {
    WebDriver driver;

    public CustomerPageObejct(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameTextboAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
        return getWebElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
        return getWebElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
        return getWebElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
    }
}
