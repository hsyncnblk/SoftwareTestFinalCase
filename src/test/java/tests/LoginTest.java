package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Listeners.TestListeners;
import utils.ScreenshotHelper;
import utils.WebDriverFactory;

@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;


    @Description("Test Description: Login test with valid username and valid password.")
    @Test(priority = 1, description="Success Login Scenario with valid username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid username and password login test")
    public void testLogin(){
        homePage = new HomePage(WebDriverFactory.getDriver());

        loginPage = new LoginPage(WebDriverFactory.getDriver());

        homePage.loginScreen();

        ScreenshotHelper.takeScreenshot(WebDriverFactory.getDriver(), "login_screenshot");


        loginPage.login();

    }
}
