package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            Log.info("WebDriver instance is being created...");

            ChromeOptions options = new ChromeOptions();

            // options.addArguments("-disable-blink-features=AutomationControlled");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Log.info("WebDriver instance created and window maximized.");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            Log.info("Closing WebDriver instance...");
            driver.quit();
            driver = null;
            Log.info("WebDriver instance closed successfully.");
        }
    }
}
