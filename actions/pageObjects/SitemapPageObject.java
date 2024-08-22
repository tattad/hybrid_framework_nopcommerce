package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SitemapPageObject extends BasePage {
    WebDriver driver;

    public SitemapPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
