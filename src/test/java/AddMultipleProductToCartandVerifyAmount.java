import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.*;

import java.util.Iterator;
import java.util.Set;

public class AddMultipleProductToCartandVerifyAmount extends Basic {
    @BeforeMethod
    public void openBrowser() {
        driver = LaunchBrowser.openBrowser("https://www.naaptol.com/");
    }


    @Test
    public void verifyAmountOfMultipleProductInCart() throws InterruptedException {
        NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
        naptolHomePage.enterProductToSearch("mobile");
        naptolHomePage.clickOnSearchButton();
        AddProductToCartFromProductDiscriptionPage addProductToCartFromProductDiscriptionPage = new AddProductToCartFromProductDiscriptionPage(driver);
        addProductToCartFromProductDiscriptionPage.getProductTitleFromDiscription(driver,7);
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
        try {
            searchResultPage.cliclToColour(driver);
        }catch (Exception e)
        {
            System.out.println("no such element");
        }
        addProductToCartFromProductDiscriptionPage.clickHereToBuyButton();
        AddProductToCartFromQuickView addToCartPage = new AddProductToCartFromQuickView(driver);
        String getOrderAmount = addToCartPage.getOrderAmount(driver);
        Thread.sleep(3000);
        addToCartPage.ContinueShopping();
        Thread.sleep(3000);
        driver.switchTo().window(ParaentWindowHandle);
        AddProductToCartFromProductDiscriptionPage addProductToCartFromProductDiscriptionPage1 = new AddProductToCartFromProductDiscriptionPage(driver);
        addProductToCartFromProductDiscriptionPage1.getProductTitleFromDiscription(driver,6);
        addProductToCartFromProductDiscriptionPage1.clickOnDiscriptionProductTitle(6);
        Set<String> handles1 = driver.getWindowHandles();
        Iterator<String> j=handles1.iterator();
        while(j.hasNext()) {
            String handle = j.next();
            driver.switchTo().window(handle);
            String currentTitle1 = driver.getTitle();
        }
        try {
            searchResultPage.cliclToColour(driver);
        }catch (Exception e)
        {
            System.out.println("no such element");
        }
        addProductToCartFromProductDiscriptionPage.clickHereToBuyButton();
        Thread.sleep(2000);
        //        for First Cart Product Calculation
        CartAmountPage cartAmountPage = new CartAmountPage(driver);
        String UnitPrice1 = cartAmountPage.getUnitPriceOfMultipleCartProduct(2).replaceAll("[^0-9]", "");
        int UnitPrice = Integer.parseInt(UnitPrice1);
        System.out.println(UnitPrice);
        String ShippingCharge1 = cartAmountPage.getShippingChargeOfMultipleCartProduct(2).replaceAll("[^0-9]", "");
        int ShippingCharge = Integer.parseInt(ShippingCharge1);
        System.out.println(ShippingCharge);
        int totaluintshipping = UnitPrice + ShippingCharge;
        System.out.println("First Product Total="+totaluintshipping);
        String Totalunitshipping = Integer.toString(totaluintshipping);
        String OrderAmount = cartAmountPage.getOrderAmountOfMultipleCartProduct(2).replaceAll("[^0-9]", "");
        Assert.assertTrue(OrderAmount.contains(Totalunitshipping));
        Thread.sleep(3000);

        //        for Second Cart Product Calculation

        String unitprice2 = cartAmountPage.getUnitPriceOfMultipleCartProduct(1).replaceAll("[^0-9]", "");
        int UnitPrice2 = Integer.parseInt(unitprice2);
        System.out.println(UnitPrice2);
        String shippingcharge2 = cartAmountPage.getShippingChargeOfMultipleCartProduct(1).replaceAll("[^0-9]", "");
        int ShippingCharge2 = Integer.parseInt(shippingcharge2);
        System.out.println(ShippingCharge2);
        int totaluintshipping2 = UnitPrice2 + ShippingCharge2;
        System.out.println("Second Product Total="+totaluintshipping2);
        String Totalunitshipping2 = Integer.toString(totaluintshipping2);
        String OrderAmount2 = cartAmountPage.getOrderAmountOfMultipleCartProduct(1).replaceAll("[^0-9]", "");
        Assert.assertTrue(OrderAmount2.contains(Totalunitshipping2));

//        Calculation of Order Amount

        String OrderAmount1  = cartAmountPage.getOrderAmountOfMultipleCartProduct(2).replaceAll("[^0-9]", "");
        int OrderAmountFirstProduct = Integer.parseInt(OrderAmount1);
        String OrderAmountproduct2 = cartAmountPage.getOrderAmountOfMultipleCartProduct(1).replaceAll("[^0-9]", "");
        int OderAmountSecondProduct = Integer.parseInt(OrderAmountproduct2);
        int TotalOrderAmount = OrderAmountFirstProduct + OderAmountSecondProduct;
        System.out.println("TotalOrderAmount = " + TotalOrderAmount);



//        Compare Cart Amount and Order Amount(Both Should Equal)
        String totalamount = Integer.toString(TotalOrderAmount);
        String cartamountcmp = cartAmountPage.getOrderAmountCart(driver);
        String CartAmountcmp1 = cartAmountPage.getOrderAmountCart(driver).replaceAll("[^0-9]", "");
        Assert.assertTrue(CartAmountcmp1.contains(totalamount));


//               Cart Amount/GiftVoucher/Total Amount Calculation


        String cartamount = cartAmountPage.getOrderAmountCart(driver);
        String CartAmount1 = cartAmountPage.getOrderAmountCart(driver).replaceAll("[^0-9]", "");
        int CartAmount = Integer.parseInt(CartAmount1);
        System.out.println("Cart Amount ="+CartAmount);
        String giftvoucherdiscount = cartAmountPage.getGiftVoucherDiscount();
        String GiftVoucherDiscount2 = cartAmountPage.getGiftVoucherDiscount().replaceAll("[^0-9]", "");
        int GiftVoucherDiscount = Integer.parseInt(GiftVoucherDiscount2);
        System.out.println("Gift Voucher Discount =" +GiftVoucherDiscount);
        int total = CartAmount - GiftVoucherDiscount;
        System.out.println("Total Amount ="+total);
        String Total = Integer.toString(total);
        String Totalamount = cartAmountPage.getTotalAmount();
        String TotalAmount = cartAmountPage.getTotalAmount().replaceAll("[^0-9]", "");
        Assert.assertTrue(TotalAmount.contains(Total));

    }
}

