import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.NaptolHomePage;
import pom.SearchResultPage;

public class NaptolProductSearchTest extends Basic {
    @BeforeMethod
    public void openBrowser(){
        driver= LaunchBrowser.openBrowser("https://www.naaptol.com/");
    }
    @Test
    public void productSearchTest(){
        NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        int products = searchResultPage.getNumberOfProductDisplayedAfterSearch();
        Assert.assertTrue(products > 0);
        Assert.assertTrue(driver.getTitle().contains("mobile"));
    }

    @Test
    public void verifyIfProductIsVisibleInQuickViewTab()  {
        NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String title = searchResultPage.getProductTitle(4);
        System.out.println(title);
        searchResultPage.moveToDesiredProduct(driver,4);
        searchResultPage.clickOnQuickView(4);
        String actualTitle = searchResultPage.getProductTitleFromQuickViewTab(driver);
        System.out.println(actualTitle);
//        Assert.assertEquals(title,actualTitle);
        Assert.assertTrue(actualTitle.contains(title));
        searchResultPage.enterPinCode("416401");
        searchResultPage.clickOnCheckButton();
        searchResultPage.cliclToColour(driver);
        searchResultPage.clickOnClickHereToBuyButton();




    }



}
