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

public class AddMultipleProductToCartFromProductDiscriptionPage extends Basic {
    @BeforeMethod
    public void openBrowser() {
        driver = LaunchBrowser.openBrowser("https://www.naaptol.com/");
    }


    @Test
    public void verifyIfMultipleProductIsAddedFromDiscriptionPage() throws InterruptedException {
        NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        AddProductToCartFromProductDiscriptionPage addProductToCartFromProductDiscriptionPage = new AddProductToCartFromProductDiscriptionPage(driver);
        String ActualTitle= addProductToCartFromProductDiscriptionPage.getProductTitleFromDiscription(driver,7);
        System.out.println(ActualTitle);
        String ParaentWindowHandle = driver.getWindowHandle();
        addProductToCartFromProductDiscriptionPage.clickOnDiscriptionProductTitle(7);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i=handles.iterator();
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
        addToCartPage.ContinueShopping();
        Thread.sleep(3000);
        driver.switchTo().window(ParaentWindowHandle);
        AddProductToCartFromProductDiscriptionPage addProductToCartFromProductDiscriptionPage1 = new AddProductToCartFromProductDiscriptionPage(driver);
        String ActualTitle1= addProductToCartFromProductDiscriptionPage1.getProductTitleFromDiscription(driver,6);
        System.out.println(ActualTitle1);
        addProductToCartFromProductDiscriptionPage1.clickOnDiscriptionProductTitle(6);
        Set<String> handles1 = driver.getWindowHandles();
        Iterator<String> j=handles1.iterator();
        while(j.hasNext()) {
            String handle = j.next();
            driver.switchTo().window(handle);
            String currentTitle1 = driver.getTitle();
        }
        SearchResultPage searchResultPage1=new SearchResultPage(driver);
        String CurrentTitle1 = searchResultPage1.getProductTitleFromQuickViewTab(driver);
        System.out.println(CurrentTitle1);
        Assert.assertTrue(CurrentTitle1.contains(ActualTitle1));
        try {
            searchResultPage.cliclToColour(driver);
        }catch (Exception e)
        {
            System.out.println("no such element");
        }
        addProductToCartFromProductDiscriptionPage.clickHereToBuyButton();
        AddProductToCartFromQuickView addToCartPage1 = new AddProductToCartFromQuickView(driver);
        String CartProductTitle1= addToCartPage1.getcartItemsTitle(driver);
        System.out.println(CartProductTitle1);
        Assert.assertTrue(CartProductTitle1.contains(CurrentTitle1));



    }
    }


