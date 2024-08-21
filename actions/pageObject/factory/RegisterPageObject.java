package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id = "LastName")
    private WebElement lastNameTextbox;

    @FindBy(id = "Email")
    private WebElement emailTextbox;

    @FindBy(id = "Password")
    private WebElement passwordTextbox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextbox;

    @FindBy(id = "register-button")
    private WebElement registerBtn;

    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorMsg;

    @FindBy(id = "LastName-error")
    private WebElement lastNameErrorMsg;

    @FindBy(id = "Email-error")
    private WebElement emailErrorMsg;

    @FindBy(xpath = "//span[@data-valmsg-for='Password']")
    private WebElement passwordErrorMsg;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    private WebElement confirmPasswordErrorMsg;

    @FindBy(xpath = "//div[@class='header-logo']//img")
    private WebElement nopCommerceLogo;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerSuccessMsg;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickToRegisterBtn() {
        waitForElementClickable(driver, registerBtn);
        clickToElement(driver, registerBtn);
    }

    public String getFirstNameErrorMsg() {
        waitForElementVisible(driver, firstNameErrorMsg);
        return getWebElementText(driver, firstNameErrorMsg);
    }

    public String getLastNameErrorMsg() {
        waitForElementVisible(driver, lastNameErrorMsg);
        return getWebElementText(driver, lastNameErrorMsg);
    }

    public String getEmailErrorMsg() {
        waitForElementVisible(driver, emailErrorMsg);
        return getWebElementText(driver, emailErrorMsg);
    }

    public String getPasswordErrorMsg() {
        waitForElementVisible(driver, passwordErrorMsg);
        return getWebElementText(driver, passwordErrorMsg);
    }

    public String getConfirmPasswordErrorMsg() {
        waitForElementVisible(driver, confirmPasswordErrorMsg);
        return getWebElementText(driver, confirmPasswordErrorMsg);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, nopCommerceLogo);
        clickToElement(driver, nopCommerceLogo);
    }

    public void enterToFirstNameTextbox(String firstNameValue) {
        waitForElementVisible(driver, firstNameTextbox);
        sendkeyToElement(driver, firstNameTextbox, firstNameValue);
    }

    public void enterToLastNameTextbox(String lastNameValue) {
        waitForElementVisible(driver, lastNameTextbox);
        sendkeyToElement(driver, lastNameTextbox, lastNameValue);
    }

    public void enterToEmailTextbox(String emailValue) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(driver, emailTextbox, emailValue);
    }

    public void enterToPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(driver, passwordTextbox, passwordValue);
    }

    public void enterToConfirmPasswordTextbox(String confirmPasswordValue) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendkeyToElement(driver, confirmPasswordTextbox, confirmPasswordValue);
    }

    public String getRegisterSuccessMsg() {
        waitForElementVisible(driver, registerSuccessMsg);
        return getWebElementText(driver, registerSuccessMsg);
    }
}
