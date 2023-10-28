import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.AddProductToCartFromQuickView;
import pom.NaptolHomePage;
import pom.SearchResultPage;

public class AddProductToCartFromQuickViewTest extends Basic {
    @BeforeMethod
    public void openBrowser(){
        driver= LaunchBrowser.openBrowser("https://www.naaptol.com/");
    }


    @Test
    public void verifyIfProductIsAddedOnCart(){
        NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.moveToDesiredProduct(driver,5);
        searchResultPage.clickOnQuickView(5);
        String actualTitle = searchResultPage.getProductTitleFromQuickViewTab(driver);
        System.out.println(actualTitle);
        searchResultPage.enterPinCode("416401");
        searchResultPage.clickOnCheckButton();
        try {
            searchResultPage.cliclToColour(driver);
        }catch (Exception e)
        {
            System.out.println("no such element");
        }
        searchResultPage.clickOnClickHereToBuyButton();
        AddProductToCartFromQuickView addToCartPage = new AddProductToCartFromQuickView(driver);
        String CartProductTitle= addToCartPage.getcartItemsTitle(driver);
        System.out.println(CartProductTitle);
        Assert.assertTrue(actualTitle.contains(CartProductTitle));



    }
    @Test
    public void verifyProductPrice()  {
        NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.moveToDesiredProduct(driver,2);
        searchResultPage.clickOnQuickView(2);
        try {
            searchResultPage.cliclToColour(driver);
        }catch (Exception e)
        {
            System.out.println("no such element");
        }
        searchResultPage.clickOnClickHereToBuyButton();
        AddProductToCartFromQuickView addToCartPage = new AddProductToCartFromQuickView(driver);
        String UnitPrice = addToCartPage.getUnitPrice(driver);
        int Unitprice =Integer.parseInt((UnitPrice.substring(3,6)));
        System.out.println(Unitprice);
        String ShippingCharge = addToCartPage.getShippingCharge();
        int Shippingcharge = Integer.parseInt((ShippingCharge.substring(3,6)));
        System.out.println(Shippingcharge);
        int totalcharge = Unitprice + Shippingcharge;
        System.out.println(totalcharge);
        String total = Integer.toString(totalcharge);
        String getOrderAmount = addToCartPage.getOrderAmount(driver);
        String OrderAmount = getOrderAmount.replaceAll("[^0-9]", "");
        System.out.println(OrderAmount);
        Assert.assertTrue(OrderAmount.contains(total));
        addToCartPage.ContinueShopping();

    }


}
