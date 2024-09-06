package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage {
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        return PageGeneratorManager.getOrderPage(driver);
    }

    public RewardPointsPageObject openRewardPointsPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINK_TEXT);
        return PageGeneratorManager.getRewardPointsPage(driver);
    }

    public CustomerPageObejct openCustomerPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public MyAccountSideBarPageObject openDynamicSidebarPage(String pageName) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT, pageName);

        switch (pageName) {
            case "Customer info":
                return PageGeneratorManager.getCustomerPage(driver);
            case "Addresses":
                return PageGeneratorManager.getAddressPage(driver);
            case "Orders":
                return PageGeneratorManager.getOrderPage(driver);
            case "Reward points":
                return PageGeneratorManager.getRewardPointsPage(driver);
            default:
                new RuntimeException("Sidebar page name is incorrect!");
                return null;
        }
    }

    public void openDynamicSidebarPageByName(String pageName) {
        waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINK_TEXT, pageName);
    }
}
