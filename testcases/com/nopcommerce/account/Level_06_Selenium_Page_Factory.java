package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.factory.CustomerPageObject;
import pageObject.factory.HomePageObject;
import pageObject.factory.LoginPageObject;
import pageObject.factory.RegisterPageObject;

import java.util.Random;

public class Level_06_Selenium_Page_Factory extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.clickToRegisterBtn();
        Assert.assertEquals(registerPage.getFirstNameErrorMsg(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsg(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsg(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox("abc@def@gh");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getEmailErrorMsg(), "Please enter a valid email address.");
    }

    @Test
    public void User_03_Register_Invalid_Password() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox("abc@gmail.com");
        registerPage.enterToPasswordTextbox("123");
        registerPage.enterToConfirmPasswordTextbox("123");

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getPasswordErrorMsg(), "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox("abc@gmail.com");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("1234567");

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getRegisterSuccessMsg(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        registerPage.clickToNopCommerceLogo();

//        homePage = new HomePageObject(driver);
//        homePage.clickToLogoutLink();
//        homePage.clickToLoginLink();

//        loginPage = new LoginPageObject(driver);
//        loginPage.enterToEmailTextbox(emailAddress);
//        loginPage.enterToPasswordTextbox("123456");
//        loginPage.clickToLoginBtn();

        homePage = new HomePageObject(driver);
        homePage.clickToMyAccountLink();

        customerPage = new CustomerPageObject(driver);
        Assert.assertEquals(customerPage.getFirstNameTextboAttributeValue(), "abc");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "def");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
    }

    @AfterClass
    public void afterClass() {
//        closeBrowser();
    }

    public String getEmailRandom() {
        Random rand = new Random();
        return "abc" + rand.nextInt(99999) + "@gmail.com";
    }
}
