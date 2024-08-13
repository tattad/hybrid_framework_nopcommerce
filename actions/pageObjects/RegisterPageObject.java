package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterBtn() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BTN);
        clickToElement(driver, RegisterPageUI.REGISTER_BTN);
    }

    public String getFirstNameErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    public String getLastNameErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    public String getEmailErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
    }

    public String getConfirmPasswordErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
    }

    public void enterToFirstNameTextbox(String firstNameValue) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
    }

    public void enterToLastNameTextbox(String lastNameValue) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
    }

    public void enterToEmailTextbox(String emailValue) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);
    }

    public void enterToPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
    }

    public void enterToConfirmPasswordTextbox(String confirmPasswordValue) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);
    }

    public String getRegisterSuccessMsg() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getWebElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
