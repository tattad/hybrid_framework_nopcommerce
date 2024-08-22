package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;

public class AddressPageObject extends BasePage {
    WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
