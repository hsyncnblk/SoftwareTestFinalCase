package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.*;
import utils.WebDriverFactory;

public class CartTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;

    ProductDetailPage productDetailPage;

    ProductListPage productListPage;

    FilterPage filterPage;

    CartPage cartPage;


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

    }

    @Test(priority = 3)
    public void testList(){
        productListPage = new ProductListPage(WebDriverFactory.getDriver());

        productListPage.setSales();
    }

    @Test(priority = 4)
    public void testDetail(){
        productDetailPage = new ProductDetailPage(WebDriverFactory.getDriver());

        productDetailPage.selectSize();
        productDetailPage.addToCart();
        productDetailPage.goToCart();
    }

    @Test(priority = 5)
    public void testCart(){
        cartPage = new CartPage(WebDriverFactory.getDriver());

        cartPage.verifyProduct();
    }
}
