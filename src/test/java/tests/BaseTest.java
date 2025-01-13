package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Log;
import utils.WebDriverFactory;

import java.time.Duration;

public class BaseTest {

    @BeforeClass
    public void setup() {

        WebDriverFactory.getDriver().get("https://www.lcw.com/");
        Log.info("Web page opened: https://www.lcw.com/");

        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // cookie accepted
        try {
            WebElement cookies =  WebDriverFactory.getDriver().findElement(By.xpath("//body/div[@id='cookieseal-banner']/div[1]"));
            WebElement cookiesBtn =  WebDriverFactory.getDriver().findElement(By.xpath("//button[@id='cookieseal-banner-accept']"));
            if (cookies.isDisplayed()) {
                Log.info("Cookies banner is displayed, clicking...");
                cookiesBtn.click();
            }
        } catch (Exception e) {
            Log.info("Cookies banner is not displayed.");
        }



    }

    @AfterClass
    public void tearDown() {

        WebDriverFactory.closeDriver();
    }
}
