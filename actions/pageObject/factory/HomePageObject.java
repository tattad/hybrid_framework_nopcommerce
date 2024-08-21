package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePageObject extends BasePageFactory {
    WebDriver driver;

    //Define các element bằng WebElement
    @CacheLookup
    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    private WebElement registerLlink;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccountLink;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    //Kết hợp Page Object
    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLlink);
        clickToElement(driver, registerLlink);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, logoutLink);
        clickToElement(driver, logoutLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(driver, loginLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(driver, myAccountLink);
    }
}
