package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'SEPETE EKLE')]")
    private WebElement addCart;


    @FindBy(xpath = "//header/div[1]/div[3]/div[1]/div[2]/a[1]")
    private WebElement goToCart;

    String[] sizeButtonsXpaths = {
            "//button[contains(text(),'5-6 Yaş')]",
            "//button[contains(text(),'6-7 Yaş')]",
            "//button[contains(text(),'7-8 Yaş')]",
            "//button[contains(text(),'8-9 Yaş')]",
            "//button[contains(text(),'9-10 Yaş')]",
            "//button[contains(text(),'10-11 Yaş')]",
            "//button[contains(text(),'11-12 Yaş')]",
            "//button[contains(text(),'12-13 Yaş')]",
            "//button[contains(text(),'13-14 Yaş')]"

    };

    public void selectSize(){
        for (String xpath : sizeButtonsXpaths) {

            WebElement button = driver.findElement(By.xpath(xpath));

            if (button.isEnabled()) {
                clickElement(button);
                break;

            }
        }
    }

    public void addToCart(){
        clickElement(addCart);
    }

    public void goToCart(){
        clickElement(goToCart);
    }

}
