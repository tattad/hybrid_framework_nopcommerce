package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static CustomerPageObejct getCustomerPage(WebDriver driver) {
        return new CustomerPageObejct(driver);
    }

    public static AddressPageObject getAddressPage(WebDriver driver) {
        return new AddressPageObject(driver);
    }

    public static OrderPageObject getOrderPage(WebDriver driver) {
        return new OrderPageObject(driver);
    }

    public static RewardPointsPageObject getRewardPointsPage(WebDriver driver) {
        return new RewardPointsPageObject(driver);
    }

    public static SitemapPageObject getSitemapPage(WebDriver driver) {
        return new SitemapPageObject(driver);
    }

    public static PrivacyNoticePageObject getPrivacyNoticePage(WebDriver driver) {
        return new PrivacyNoticePageObject(driver);
    }

    public static BlogPageObject getBlogPage(WebDriver driver) {
        return new BlogPageObject(driver);
    }
}
