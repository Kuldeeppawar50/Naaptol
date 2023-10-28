import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.AddProductToCartFromProductDiscriptionPage;
import pom.AddProductToCartFromQuickView;
import pom.NaptolHomePage;
import pom.SearchResultPage;

import java.util.Iterator;
import java.util.Set;


public class AddProductToCartFromProductDiscriptionPageTest extends Basic {
    @BeforeMethod
    public void openBrowser() {
        driver = LaunchBrowser.openBrowser("https://www.naaptol.com/");
    }

    @Test
    public void verifyIfProductaddtoCarFromProductDiscriptionPage()  {
        NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        AddProductToCartFromProductDiscriptionPage addProductToCartFromProductDiscriptionPage = new AddProductToCartFromProductDiscriptionPage(driver);
        String ActualTitle= addProductToCartFromProductDiscriptionPage.getProductTitleFromDiscription(driver,7);
        System.out.println(ActualTitle);
        addProductToCartFromProductDiscriptionPage.clickOnDiscriptionProductTitle(7);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String>i=handles.iterator();
        while(i.hasNext()) {
            String handle = i.next();
            driver.switchTo().window(handle);
            String currentTitle = driver.getTitle();
        }
        SearchResultPage searchResultPage=new SearchResultPage(driver);
        String CurrentTitle = searchResultPage.getProductTitleFromQuickViewTab(driver);
        System.out.println(CurrentTitle);
        Assert.assertTrue(CurrentTitle.contains(ActualTitle));
        try {
            searchResultPage.cliclToColour(driver);
        }catch (Exception e)
        {
            System.out.println("no such element");
        }
        addProductToCartFromProductDiscriptionPage.clickHereToBuyButton();
        AddProductToCartFromQuickView addToCartPage = new AddProductToCartFromQuickView(driver);
        String CartProductTitle= addToCartPage.getcartItemsTitle(driver);
        System.out.println(CartProductTitle);
        Assert.assertTrue(CartProductTitle.contains(CurrentTitle));

    }

    @Test
    public void verifyProductPriceFromProductDiscriptionPage(){
        NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        AddProductToCartFromProductDiscriptionPage addProductToCartFromProductDiscriptionPage = new AddProductToCartFromProductDiscriptionPage(driver);
        String ActualTitle= addProductToCartFromProductDiscriptionPage.getProductTitleFromDiscription(driver,7);
        System.out.println(ActualTitle);
        addProductToCartFromProductDiscriptionPage.clickOnDiscriptionProductTitle(7);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String>i=handles.iterator();
        while(i.hasNext()) {
            String handle = i.next();
            driver.switchTo().window(handle);
            String currentTitle = driver.getTitle();
        }
        SearchResultPage searchResultPage=new SearchResultPage(driver);

        try {
            searchResultPage.cliclToColour(driver);
        }catch (Exception e)
        {
            System.out.println("no such element");
        }
        addProductToCartFromProductDiscriptionPage.clickHereToBuyButton();
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