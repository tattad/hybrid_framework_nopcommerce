package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Random;

import static commons.BrowserList.CHROME;
import static commons.BrowserList.FIREFOX;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
//        if (browser == FIREFOX) {
//            driver = new FirefoxDriver();
//        } else if (browser == CHROME) {
//            driver = new ChromeDriver();
//        } else if (browser == BrowserList.EDGE) {
//            driver = new EdgeDriver();
//        } else {
//            throw new RuntimeException("Browser name is invalid.");
//        }

        switch (browser) {
            case FIREFOX:
                //4.x 5.x: Tải về driver và setting biến môi trường
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();

                //5.x: Tải về driver + setting biến môi trường và khởi tạo browser lên
                driver = WebDriverManager.firefoxdriver().create();

                //Selenium Manager
//                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
                break;
            case OPERA:
                driver = WebDriverManager.operadriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is invalid.");
        }

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get("http://demo.nopcommerce/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    protected String getEmailRandom() {
        Random rand = new Random();
        return "abc" + rand.nextInt(99999) + "@gmail.com";
    }

    protected void closeBrowser() {
        if (!(driver == null)) {
            driver.quit();
        }
    }
}
