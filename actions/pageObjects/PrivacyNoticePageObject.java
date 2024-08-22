package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PrivacyNoticePageObject extends BasePage {
    WebDriver driver;

    public PrivacyNoticePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
