package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.Listeners.TestListeners;
import utils.ScreenshotHelper;
import utils.WebDriverFactory;


@Listeners({ TestListeners.class })
@Epic("Regression Tests")
@Feature("Cart Tests")
public class CartTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;

    ProductDetailPage productDetailPage;

    FilterPage filterPage;

    CartPage cartPage;


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


    @Description("Test Description: Selecting a product size, adding it to the cart, and navigating to the cart.")
    @Test(priority = 3, description = "Success Product Detail Scenario with size selection and add to cart.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Product detail page: Select size, add to cart, and go to cart")
    public void testDetail(){
        productDetailPage = new ProductDetailPage(WebDriverFactory.getDriver());

        productDetailPage.selectSize();
        productDetailPage.addToCart();

        ScreenshotHelper.takeScreenshot(WebDriverFactory.getDriver(), "detail_screenshot");

        productDetailPage.goToCart();
    }

    @Description("Test Description: Verify product details, increase and decrease quantity in the cart.")
    @Test(priority = 4, description = "Verify product details and perform quantity operations in the cart.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cart operations: Product verification and quantity management")
    public void testCart(){
        cartPage = new CartPage(WebDriverFactory.getDriver());

        cartPage.verifyProduct();

        ScreenshotHelper.takeScreenshot(WebDriverFactory.getDriver(), "cart_screenshot");


        cartPage.quantitiyTest();

        cartPage.removeQuantityTest();
    }
}
