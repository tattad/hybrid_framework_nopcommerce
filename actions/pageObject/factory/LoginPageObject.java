package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageFactory {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddres) {
    }

    public void enterToPasswordTextbox(String number) {
    }

    public void clickToLoginBtn() {
    }
}
