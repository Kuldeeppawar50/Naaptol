package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddProductToCartFromQuickView {
    @FindBy(xpath = "//ul[@id=\"cartData\"]/li[1]/div[2]/h2/a")
    private WebElement items;
    @FindBy(xpath = "//ul[@id=\"cartData\"]/li[3]")
    private WebElement unitPrice;
    @FindBy(xpath = "//ul[@id=\"cartData\"]/li[4]")
    private WebElement ShippingCharge;
    @FindBy(xpath = "//ul[@id=\"cartData\"]/li[5]")
    private WebElement orderAmount;
    @FindBy(xpath = "//ul[@id=\"shopCartHead\"]/li[2]/a[1]")
    private WebElement ContinueShopping;
    @FindBy(xpath = "//ul[@id=\"cartData\"]/li[1]/div[2]/p[3]/a")
    private WebElement Remove;









    public AddProductToCartFromQuickView(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public String getcartItemsTitle(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(items));
       return items.getText();
    }
    public String getUnitPrice(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(unitPrice));
        return unitPrice.getText();
    }
    public String getShippingCharge() {
        return ShippingCharge.getText();
    }
    public String getOrderAmount(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(orderAmount));
        return orderAmount.getText();
    }
    public void ContinueShopping(){
        ContinueShopping.click();
    }
    public void ClickOnRemoveProduct(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(Remove));
        Remove.click();
    }

}
