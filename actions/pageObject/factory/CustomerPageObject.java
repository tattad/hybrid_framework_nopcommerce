package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;

public class CustomerPageObject extends BasePageFactory {
    WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameTextboAttributeValue() {
        return null;
    }

    public String getLastNameTextboxAttributeValue() {
        return null;
    }

    public String getEmailAddressTextboxAttributeValue() {
        return null;
    }
}
