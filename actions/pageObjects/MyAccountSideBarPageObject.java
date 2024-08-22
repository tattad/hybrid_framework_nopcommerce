package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage {
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        return PageGeneratorManager.getOrderPage(driver);
    }

    public RewardPointsPageObject openRewardPointsPage(WebDriver driver) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINK_TEXT);
        return PageGeneratorManager.getRewardPointsPage(driver);
    }

    public CustomerPageObejct openCustomerPage(WebDriver driver) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT);
        return PageGeneratorManager.getCustomerPage(driver);
    }
}
