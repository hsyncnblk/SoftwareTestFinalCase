package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage{
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]")
    private WebElement clickElement;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[3]/div[2]")
    private WebElement bejColor;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/input[1]")
    private WebElement colorSearch;

    @FindBy(xpath = "//*[@id='icon-angle-down']")
    private WebElement list;

    @FindBy(xpath = "//a[contains(text(),'En çok satanlar')]")
    private WebElement mostSales;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[2]/div[4]/a[1]/div[1]/img[1]")
    private WebElement fourthProduct;

    public void setSales(){


        clickElement(list);

        clickElement(mostSales);

        click(fourthProduct);

        driver.navigate().refresh();
    }
}
