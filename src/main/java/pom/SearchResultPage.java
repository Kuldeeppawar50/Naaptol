package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultPage {
    @FindBy(xpath = "//div[@class=\"grid_Square \"]")
    private List<WebElement> products;
    @FindBy(xpath = "//a[@href='#QuickView']")
    private List<WebElement> quickView;
    @FindBy(xpath = "//div[@class='item_title']//a")
    private List<WebElement> productTitle;
    @FindBy(xpath = "//div[@id='square_Details']/h1")
    private WebElement quickViewProductTitle;
    @FindBy(xpath = "//a[@id='cart-panel-button-0']")
    private WebElement clickHereToBuyButton;
    @FindBy(xpath = "//input[@id='pincodeDeliveryId_0']")
    private WebElement enterPinCode;
    @FindBy(xpath = "//ul[@id=\"color_box_0\"]/li[1]/a")
    private WebElement selectBlueColour;
    @FindBy(xpath = "//div[@id='pincodeForDeliveryDiv_provide_0']/a/span")
    private WebElement checkButton;



    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public int getNumberOfProductDisplayedAfterSearch(){
        return products.size();
    }
    public void moveToDesiredProduct(WebDriver driver, int index){
        Actions actions=new Actions(driver);
        actions.moveToElement(products.get(index));
        actions.perform();
    }
    public void clickOnDesiredProduct(int index){
        products.get(index).click();
    }
    public String getProductTitle(int index){
        return productTitle.get(index).getText();
    }
    public void clickOnQuickView(int index){
        quickView.get(index).click();
    }
    public String getProductTitleFromQuickViewTab(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(quickViewProductTitle));
        return quickViewProductTitle.getText();
    }
    public void clickOnClickHereToBuyButton(){
        clickHereToBuyButton.click();
    }
    public void enterPinCode(String pincode){
        enterPinCode.sendKeys(pincode);
    }
    public void clickOnCheckButton(){
        checkButton.click();
    }
    public void cliclToColour(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOf(selectBlueColour));
        selectBlueColour.click();
    }

}
