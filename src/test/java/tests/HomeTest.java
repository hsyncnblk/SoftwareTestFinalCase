package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.WebDriverFactory;

public class HomeTest extends BaseTest{

    HomePage homePage;

    @Test(priority = 1)
    public void goToLogin(){
        homePage = new HomePage(WebDriverFactory.getDriver());

        homePage.loginScreen();
    }
}
