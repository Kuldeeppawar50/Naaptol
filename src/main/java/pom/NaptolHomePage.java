package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class NaptolHomePage {
    @FindBy(xpath = "//a[@id='login-panel-link']")
    private WebElement loginOrRegister;
    @FindBy(xpath = "//a[text()='Track Order']")
    private WebElement trackOrder;
    @FindBy(xpath = "//div[@onmouseover='javascript:menu.showMainMenu(true)']")
    private WebElement shoppingCategories;
    @FindBy(xpath = "//input[@id='header_search_text']")
    private WebElement searchBox;
    @FindBy(xpath = "(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@id='cart-panel-link'])[2]")
    private WebElement cartButton;
    @FindBy(xpath = "//input[@id='registration-basic-panel-mobile']")
    private WebElement enterMobileNo;
    @FindBy(xpath = "//input[@id='registration-basic-panel-submit']")
    private WebElement continueButton;
    @FindBy(xpath = "//a[@href='/faces/jsp/components/header/logOut.jsp']")
    private WebElement LogoutButton;
    @FindBy(xpath = "//b[text()='User']")
    private WebElement userName;
    @FindBy(xpath = "//li[text()='Product Code: 12609299']")
    private WebElement Product;





    public NaptolHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickonLoginOrRegister() {
        loginOrRegister.click();
    }

    public void clickOnTrackOrder() {
        trackOrder.click();
    }

    public void moveToShoppingCategories(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCategories);
        actions.perform();
    }

    public void enterProductToSearch(String product) {
        searchBox.sendKeys(product);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnCart() {
        cartButton.click();
    }
    public void EnterMobileNo(String mobileNo){
        enterMobileNo.sendKeys(mobileNo);
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }
    public boolean logoutButtonDisplayed(){
       return LogoutButton.isDisplayed();
    }
    public String getUserName(){
      return  userName.getText();
    }
    public void clickOnLogoutButton(){
        LogoutButton.click();
    }
    public boolean loginOrRegisterDisplayed(){
        return loginOrRegister.isDisplayed();
    }
    public String getProductCode(){
        return Product.getText();
    }


}
