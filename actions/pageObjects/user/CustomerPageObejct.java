package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.CustomerPageUI;

public class CustomerPageObejct extends MyAccountSideBarPageObject {
    WebDriver driver;

    public CustomerPageObejct(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTextboAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
    }
}
