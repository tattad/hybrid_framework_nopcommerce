package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddres) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddres);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObject clickToLoginBtn() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BTN);
        clickToElement(driver, UserLoginPageUI.LOGIN_BTN);
        return new HomePageObject(driver);
    }

    public HomePageObject loginToUser(String emailAddres, String password) {
        enterToEmailTextbox(emailAddres);
        enterToPasswordTextbox(password);
        return clickToLoginBtn();
    }
}
