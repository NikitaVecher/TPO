package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
    public static WebDriver getDriver(String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }
}
