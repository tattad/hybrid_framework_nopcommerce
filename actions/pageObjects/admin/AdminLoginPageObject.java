package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_ADDRESS_TXT);
        sendkeyToElement(driver, AdminLoginPageUI.EMAIL_ADDRESS_TXT, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TXT);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TXT, password);
    }

    public AdminDashboardPageObject clickToLoginBtn() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BTN);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BTN);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject loginToAdmin(String emailAddress, String password) {
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        return clickToLoginBtn();
    }
}
