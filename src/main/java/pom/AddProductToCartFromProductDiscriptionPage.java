package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddProductToCartFromProductDiscriptionPage {
    @FindBy(xpath = "//div[@class=\"grid_Square \"]")
    private List<WebElement> products;
    @FindBy(xpath = "//div[@class=\"item_title\"]")
    private List<WebElement> DiscriptionProductTitle;
    @FindBy(xpath = "//div[@class='item_image']")
    private List<WebElement> ProductTitleDiscription;
    @FindBy(xpath = "//a[@class='red_button icon chat']")
    private WebElement buybutton;
    @FindBy(xpath = "//div[@id='square_Details']/h1")
    private List<WebElement>PopupWindowProductTitle;







    public AddProductToCartFromProductDiscriptionPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void moveToDesiredProduct(WebDriver driver, int index){
        Actions actions=new Actions(driver);
        actions.moveToElement(products.get(index));
        actions.perform();
    }
    public void clickOnDesiredProduct(int index){
        products.get(index).click();
    }
    public void clickOnDiscriptionProductTitle(int index){
        ProductTitleDiscription.get(index).click();
    }
    public String getProductTitleFromDiscription(WebDriver driver,int index){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(DiscriptionProductTitle.get(index)));
        return DiscriptionProductTitle.get(index).getText();
    }
    public void clickHereToBuyButton(){
        buybutton.click();
    }


    }

