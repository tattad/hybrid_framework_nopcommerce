package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterBtn() {
    }

    public String getFirstNameErrorMsg() {
    }

    public String getLastNameErrorMsg() {
    }

    public String getEmailErrorMsg() {
    }

    public String getConfirmPasswordErrorMsg() {
    }

    public void clickToNopCommerceLogo() {
    }

    public void enterToFirstNameTextbox(String abc) {
    }

    public void enterToLastNameTextbox(String def) {
    }

    public void enterToEmailTextbox(String s) {
    }

    public void enterToPasswordTextbox(String number) {
    }

    public void enterToConfirmPasswordTextbox(String number) {
    }

    public byte[] getRegisterSuccessMsg() {
    }
}
