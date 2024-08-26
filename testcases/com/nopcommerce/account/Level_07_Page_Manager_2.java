package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObejct;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

import java.util.Random;

public class Level_07_Page_Manager_2 extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObejct customerPage;
    private String emailAddres = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = new HomePageObject(driver);
    }

    @Test
    public void User_01_Register_Empty_Data() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getFirstNameErrorMsg(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsg(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsg(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

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
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

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
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

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
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox(emailAddres);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getRegisterSuccessMsg(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToLogoutLink();
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(emailAddres);
        loginPage.enterToPasswordTextbox("123456");
        homePage = loginPage.clickToLoginBtn();

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboAttributeValue(), "abc");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "def");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddres);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    public String getEmailRandom() {
        Random rand = new Random();
        return "abc" + rand.nextInt(99999) + "@gmail.com";
    }
}
