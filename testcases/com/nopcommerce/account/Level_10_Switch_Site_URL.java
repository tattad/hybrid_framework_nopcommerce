package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.*;

import java.util.Random;

public class Level_10_Switch_Site_URL extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject userLoginPage;
    private CustomerPageObejct customerPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewardPointsPageObject rewardPointsPage;
    private SitemapPageObject sitemapPage;
    private PrivacyNoticePageObject privacyNoticePage;
    private BlogPageObject blogPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private String emailAddress = getEmailRandom();

    private String adminUrl, endUserUrl;

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        this.adminUrl = adminUrl;
        this.endUserUrl = userUrl;

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_User_To_Admin() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("abc");
        registerPage.enterToLastNameTextbox("def");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterBtn();

        Assert.assertEquals(registerPage.getRegisterSuccessMsg(), "Your registration completed");

        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToLogoutLink();
        userLoginPage = homePage.clickToLoginLink();

        homePage = userLoginPage.loginToUser(emailAddress, "123456");
        homePage.clickToLogoutLink();

        //Home Page (User) -> Login Page (Admin)
//        homePage.openPageURL(driver, this.adminUrl);
        homePage.clickToLoginLink();

        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminDashboardPage = adminLoginPage.loginToAdmin("admin@nopcommerce.com", "admin@nopcommerce.com");
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
    }

    @Test
    public void User_02_Admin_To_User() {
        adminLoginPage = adminDashboardPage.clickToLogoutLink();

        //LoginPage (admin) -> Home Page (user)
        adminLoginPage.openPageURL(driver, this.endUserUrl);
        homePage = PageGeneratorManager.getHomePage(driver);

        userLoginPage = homePage.clickToLoginLink();
        homePage = userLoginPage.loginToUser(emailAddress, "123456");
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
