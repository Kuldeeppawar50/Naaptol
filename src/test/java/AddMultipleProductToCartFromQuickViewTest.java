import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.AddProductToCartFromQuickView;
import pom.NaptolHomePage;
import pom.SearchResultPage;

public class AddMultipleProductToCartFromQuickViewTest extends Basic {
    @BeforeMethod
    public void openBrowser(){
        driver= LaunchBrowser.openBrowser("https://www.naaptol.com/");
    }


    @Test
    public void verifyIfMultipleProductIsAddedOnCart() throws InterruptedException {
        NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.moveToDesiredProduct(driver, 5);
        searchResultPage.clickOnQuickView(5);
        String actualTitle = searchResultPage.getProductTitleFromQuickViewTab(driver);
        System.out.println(actualTitle);
        searchResultPage.enterPinCode("416401");
        searchResultPage.clickOnCheckButton();
        try {
            searchResultPage.cliclToColour(driver);
        } catch (Exception e) {
            System.out.println("no such element");
        }
        searchResultPage.clickOnClickHereToBuyButton();
        AddProductToCartFromQuickView addToCartPage = new AddProductToCartFromQuickView(driver);
        String CartProductTitle = addToCartPage.getcartItemsTitle(driver);
        System.out.println(CartProductTitle);
        Assert.assertTrue(actualTitle.contains(CartProductTitle));
        addToCartPage.ContinueShopping();
        Thread.sleep(3000);
        searchResultPage.moveToDesiredProduct(driver, 6);
        searchResultPage.clickOnQuickView(6);
        String actualTitle1 = searchResultPage.getProductTitleFromQuickViewTab(driver);
        System.out.println(actualTitle1);
        try {
            searchResultPage.cliclToColour(driver);
        } catch (Exception e) {
            System.out.println("no such element");
        }
        Thread.sleep(3000);
        searchResultPage.clickOnClickHereToBuyButton();
        String CartProductTitle1 = addToCartPage.getcartItemsTitle(driver);
        System.out.println(CartProductTitle1);
        Assert.assertTrue(actualTitle1.contains(CartProductTitle1));
    }








    }

