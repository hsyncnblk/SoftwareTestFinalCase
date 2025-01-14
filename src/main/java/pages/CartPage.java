package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/p[4]")
    private WebElement name;



    public void verifyProduct(){

        WebElement renkElementi = driver.findElement(By.xpath("//span[@class='rd-cart-item-color']/strong"));
        WebElement quantityInput = driver.findElement(By.className("item-quantity-input"));
        WebElement productNameElement = driver.findElement(By.xpath("//span[@class='rd-cart-item-code']"));
        WebElement priceElement = driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        WebElement totalPriceElement = driver.findElement(By.xpath("//span[@class='total-grand-box-amount']"));


        String actualColor = renkElementi.getText().trim();
        String actualValue = quantityInput.getAttribute("value");
        String actualProductName = productNameElement.getText().trim();

        String priceValue = priceElement.getText().trim();
        String totalPriceValue = totalPriceElement.getText().trim();




        Assert.assertEquals(actualColor, "Koyu Bej");

        Assert.assertEquals(actualValue,"1");

        Assert.assertEquals(actualProductName, "Mont");

        Assert.assertEquals(priceValue,totalPriceValue);

    }
}
