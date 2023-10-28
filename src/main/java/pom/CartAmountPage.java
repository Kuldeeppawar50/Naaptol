package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartAmountPage {
    @FindBy(xpath = "//ul[@id='cartTotal']/li[1]/label")
    private WebElement Cartamount;
    @FindBy(xpath = "//ul[@id='cartTotal']/li[2]/label")
    private WebElement Giftvoucherdiscount;
    @FindBy(xpath = "//span[@id='totalPayableAmount']")
    private WebElement totalamount;
    @FindBy(xpath = "//li[@class='head_UPrice']")
    private List<WebElement> UnitPrice;
    @FindBy(xpath = "//li[@class='head_ship']")
    private List<WebElement> ShippingCharge;
    @FindBy(xpath = "//li[@class='head_Amount']")
    private List<WebElement> orderamount;






    public CartAmountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public String getOrderAmountCart(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(Cartamount));
        return Cartamount.getText();
    }
    public String getGiftVoucherDiscount(){

        return Giftvoucherdiscount.getText();
    }
    public String getTotalAmount(){

        return totalamount.getText();
    }

    public String getUnitPriceOfMultipleCartProduct(int index){
        return UnitPrice.get(index).getText();
    }
    public String getShippingChargeOfMultipleCartProduct(int index){
        return ShippingCharge.get(index).getText();
    }
    public String getOrderAmountOfMultipleCartProduct(int index){
        return orderamount.get(index).getText();
    }

}
