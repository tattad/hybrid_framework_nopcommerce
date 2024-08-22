package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.Random;

public class Level_08_Switch_Page extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObejct customerPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewardPointsPageObject rewardPointsPage;
    private SitemapPageObject sitemapPage;
    private PrivacyNoticePageObject privacyNoticePage;
    private BlogPageObject blogPage;
    private String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getRegisterSuccessMsg(), "Your registration completed");
    }

    @Test
    public void User_02_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToLogoutLink();
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123456");
        homePage = loginPage.clickToLoginBtn();

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboAttributeValue(), "abc");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "def");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
    }

    @Test
    public void User_03_Switch_Page() {
        //Customer Page -> Address Page
        addressPage = customerPage.openAddressPage(driver);

        //Address Page -> Order Page
        orderPage = addressPage.openOrderPage(driver);

        //Order Page -> Customer Page
        customerPage = orderPage.openCustomerPage(driver);

        //Customer Page -> Order Page
        orderPage = customerPage.openOrderPage(driver);

        //Order Page -> Address Page
        addressPage = orderPage.openAddressPage(driver);

        //Address Page -> Reward Points Page
        rewardPointsPage = addressPage.openRewardPointsPage(driver);

        //Reward Points Page -> Customer Page
        customerPage = rewardPointsPage.openCustomerPage(driver);

        //Customer Page -> Reward Points Page
        rewardPointsPage = customerPage.openRewardPointsPage(driver);

        //Reward Points Page -> Sitemap Page
        sitemapPage = rewardPointsPage.getSitemapPage(driver);

        //Sitemap Page -> Privacy Notice page
        privacyNoticePage = sitemapPage.getPrivacyNoticePage(driver);

        //Privacy Notice page -> Blog Page
        blogPage = privacyNoticePage.getBlogPage(driver);
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
