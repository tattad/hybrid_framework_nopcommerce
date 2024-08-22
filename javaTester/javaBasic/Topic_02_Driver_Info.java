package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Topic_02_Driver_Info {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());

        driver = new ChromeDriver();
        sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());

        driver = new EdgeDriver();
        sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());
    }
}
