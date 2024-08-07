package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerPageObejct;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_PageObject extends BasePage {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObejct customerPage;
    private String emailAddres = getEmailRandom();

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePage = new HomePageObject();
    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject();
        registerPage.clickToRegisterBtn();
        Assert.assertEquals(registerPage.getFirstNameErrorMsg(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsg(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsg(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject();
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject();
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

        homePage = new HomePageObject();
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject();
        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox("abc@gmail.com");
        registerPage.enterToPasswordTextbox("123");
        registerPage.enterToConfirmPasswordTextbox("123");

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject();
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject();
        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox("abc@gmail.com");
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("1234567");

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject();
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject();
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
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject();
        homePage.clickToLoginLink();

        loginPage = new LoginPageObject();
        loginPage.enterToEmailTextbox(emailAddres);
        loginPage.enterToPasswordTextbox("123456");
        loginPage.clickToLoginBtn();

        homePage = new HomePageObject();
        homePage.clickToMyAccountLink();

        customerPage = new CustomerPageObejct();
        Assert.assertEquals(customerPage.getFirstNameTextboAttributeValue(),"abc");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(),"def");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(),emailAddres);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getEmailRandom() {
        Random rand = new Random();
        return "abc" + rand.nextInt(99999) + "@gmail.com";
    }
}

