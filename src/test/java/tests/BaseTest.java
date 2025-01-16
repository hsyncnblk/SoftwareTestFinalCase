package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.Log;
import utils.ScreenshotHelper;
import utils.WebDriverFactory;

import java.time.Duration;

public class BaseTest {

    @BeforeClass
    public void setup() {

        WebDriverFactory.getDriver().get("https://www.lcw.com/");
        Log.info("Web page opened: https://www.lcw.com/");

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5));



        // cookie accepted
        try {
            WebElement cookies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookieseal-banner")));
            WebElement cookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookieseal-banner-accept")));
            if (cookies.isDisplayed()) {
                Log.info("Cookies banner is displayed, clicking...");
                cookiesBtn.click();
            }
        } catch (Exception e) {
            Log.info("Cookies banner is not displayed.");
        }



    }


    @AfterMethod
    public void takeScreenshotAfterTest() {
        ScreenshotHelper.takeScreenshot(WebDriverFactory.getDriver(), "test_screenshot");
    }

    @AfterClass
    public void tearDown() {

       WebDriverFactory.closeDriver();
    }
}
