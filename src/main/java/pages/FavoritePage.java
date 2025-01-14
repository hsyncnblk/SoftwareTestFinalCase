package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FavoritePage extends BasePage{
    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@productid]")
    private WebElement productLink;

    @FindBy(xpath = "//a[starts-with(@id, 'Cart_addFavorite_')]")
    private WebElement favoriteButton;

    @FindBy(xpath = "//span[contains(text(),'Favorilerim')]")
    private WebElement goToFav;

    public void addFavorite(){
        //   String productId = productLink.getAttribute("productid");



        wait.until(ExpectedConditions.elementToBeClickable(favoriteButton));


        clickElement(favoriteButton);


        clickElement(goToFav);




    }

    public void verifyFav(){
        WebElement productTitle = driver.findElement(By.xpath("//h5[@class='product-card__title']"));
        String productTitleText = productTitle.getText();
        Assert.assertEquals(productTitleText,"Kapüşonlu Kız Çocuk Mont");
    }
}
