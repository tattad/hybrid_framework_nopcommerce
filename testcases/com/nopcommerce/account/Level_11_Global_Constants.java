package com.nopcommerce.account;

import commons.BaseTest;
import commons.GloblalConstants;
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

public class Level_11_Global_Constants extends BaseTest {

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
    private String adminUrl = GloblalConstants.DEV_ADMIN_URL;
    private String userUrl = GloblalConstants.DEV_USER_URL;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, userUrl);

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
        homePage.openPageURL(driver, adminUrl);
        homePage.clickToLoginLink();

        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminDashboardPage = adminLoginPage.loginToAdmin(GloblalConstants.DEV_ADMIN_USERNAME, GloblalConstants.DEV_ADMIN_PASSWORD);
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
    }

    @Test
    public void User_02_Admin_To_User() {
        adminLoginPage = adminDashboardPage.clickToLogoutLink();

        //LoginPage (admin) -> Home Page (user)
        adminLoginPage.openPageURL(driver, userUrl);
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
