package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FilterPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Listeners.TestListeners;
import utils.ScreenshotHelper;
import utils.WebDriverFactory;

@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("Filter Tests")
public class FilterTest extends BaseTest{

    LoginPage loginPage;

    HomePage homePage;

    FilterPage filterPage;


    @Description("Test Description: Login test with valid username and valid password.")
    @Test(priority = 1, description="Success Login Scenario with valid username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid username and password login test")
    public void testLogin() {
        homePage = new HomePage(WebDriverFactory.getDriver());

        loginPage = new LoginPage(WebDriverFactory.getDriver());

        homePage.loginScreen();

        ScreenshotHelper.takeScreenshot(WebDriverFactory.getDriver(), "login_screenshot");


        loginPage.login();

    }

    @Description("Test Description: Filtering products by category, age, color, and sorting by most sales.")
    @Test(priority = 2, description = "Success Filter Scenario with category, age, and color selection.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Filtering products based on category, age, and color")
    public void testFilter() throws InterruptedException {

        filterPage = new FilterPage(WebDriverFactory.getDriver());

        filterPage.categoryScreen();
        filterPage.filterFiveSixAge();
        filterPage.sixFilter();
        filterPage.sixAndSevenFilter();
        filterPage.setColor();
        ScreenshotHelper.takeScreenshot(WebDriverFactory.getDriver(), "filter_screenshot");

        filterPage.setSales();
    }

}
