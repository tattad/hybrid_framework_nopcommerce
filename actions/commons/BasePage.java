package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    WebDriver driver;
    // 1 - Access Modifier: public/ protected/ private/ default

    // 2 - Kiểu dữ liệu của hàm (Data type): void/ int/ String/ boolean/ WebElement/ List<WebElement>/ ...
    // Nó sẽ liên quan tới cái chức năng mình viết trong thân hàm

    // 3 - Tên hàm: Đặt tên có nghĩa theo chức năng đang cần viết
    // Convention tuân theo chuẩn của từng ngôn ngữ lập trình (Java)
    // camelCase: từ đầu tiên viết thường - chữ cái đầu tiên của các từ tiếp theo sẽ viết hoa

    // 4 - Có tham số hay không (tùy vào chức năng cần viết)

    // 5 - Kiểu dữ liệu trả về cho hàm
    // Nếu như có return dữ liệu thì sẽ khớp vs dữ liệu ở số 2
    // Nếu như có return dữ liệu thì nó là cái step cuối cùng

    /* Web Browser */
    public void openPageURL(WebDriver driver, String pageURL) {
        driver.get(pageURL);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextInAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    public void switchToWinDowTabById(WebDriver driver, String pageID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(pageID)) {
                driver.switchTo().window(id);
                sleepInSecond(1);
                break;
            }
        }
    }

    public void switchToWinDowTabByTitle(WebDriver driver, String pageTitle) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            driver.switchTo().window(id);
            sleepInSecond(1);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(pageTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
