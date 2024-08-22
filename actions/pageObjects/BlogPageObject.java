package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class BlogPageObject extends BasePage {
    WebDriver driver;

    public BlogPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
