package tests;

import org.testng.annotations.Test;
import pages.FilterPage;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

public class FilterTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;

    FilterPage filterPage;


    @Test(priority = 1)
    public void testLogin() {
        homePage = new HomePage(WebDriverFactory.getDriver());

        loginPage = new LoginPage(WebDriverFactory.getDriver());

        homePage.loginScreen();

        loginPage.login();

    }

    @Test(priority = 2)
    public void testFilter() throws InterruptedException {
        filterPage = new FilterPage(WebDriverFactory.getDriver());

        filterPage.categoryScreen();
        filterPage.filterFiveSixAge();
        filterPage.sixFilter();
        filterPage.sixAndSevenFilter();
        filterPage.setColor();
        filterPage.setSales();
    }

}
