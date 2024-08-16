package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    private WebElement registerLlink;

    @FindBy(className = "//a[@class='ico-login']")
    private WebElement loginLink;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterLink() {

    }

    public void clickToLogoutLink() {
    }

    public void clickToLoginLink() {
    }

    public void clickToMyAccountLink() {
    }
}
