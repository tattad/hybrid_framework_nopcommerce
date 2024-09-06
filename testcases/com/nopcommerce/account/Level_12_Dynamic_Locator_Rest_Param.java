package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

import java.util.Random;

public class Level_12_Dynamic_Locator_Rest_Param extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
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
    public void User_03_Page_Navigation() {
        //Customer Page -> Address Page
        addressPage = (AddressPageObject) customerPage.openDynamicSidebarPage("Addresses");

        //Address Page -> Order Page
        orderPage = (OrderPageObject) addressPage.openDynamicSidebarPage("Orders");

        //Order Page -> Customer Page
        customerPage = (CustomerPageObejct) orderPage.openDynamicSidebarPage("Customer info");

        //Customer Page -> Order Page
        orderPage = (OrderPageObject) customerPage.openDynamicSidebarPage("Orders");

        //Order Page -> Address Page
        addressPage = (AddressPageObject) orderPage.openDynamicSidebarPage("Addresses");

        //Address Page -> Reward Points Page
        rewardPointsPage = (RewardPointsPageObject) addressPage.openDynamicSidebarPage("Reward points");

        //Reward Points Page -> Customer Page
        customerPage = (CustomerPageObejct) rewardPointsPage.openDynamicSidebarPage("Customer info");

        //Customer Page -> Reward Points Page
        rewardPointsPage = (RewardPointsPageObject) customerPage.openDynamicSidebarPage("Reward points");
    }

    @Test
    public void User_04_Page_Navigation() {
        //Reward Points Page -> Customer Page
        rewardPointsPage.openDynamicSidebarPageByName("Customer info");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        //Customer Page -> Addresses Page
        customerPage.openDynamicSidebarPageByName("Addresses");
        addressPage = PageGeneratorManager.getAddressPage(driver);

        addressPage.openDynamicSidebarPageByName("Orders");
        orderPage = PageGeneratorManager.getOrderPage(driver);
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
