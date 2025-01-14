package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;


    @Test
    public void testLogin(){
        homePage = new HomePage(WebDriverFactory.getDriver());

        loginPage = new LoginPage(WebDriverFactory.getDriver());

        homePage.loginScreen();

        loginPage.login();

    }
}
