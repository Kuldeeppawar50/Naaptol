import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.LaunchBrowser;
import pom.NaptolHomePage;

public class NaptolHomePageTest extends Basic {

    @BeforeMethod
    public void openBrowser(){
        driver = LaunchBrowser.openBrowser("https://www.naaptol.com/");
    }
    @Test
    public void NaptolLoginTest() throws InterruptedException {
        NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
        naptolHomePage.clickonLoginOrRegister();
        naptolHomePage.EnterMobileNo("9021205063");
        naptolHomePage.clickOnContinueButton();
        Thread.sleep(30000);
        Assert.assertEquals(naptolHomePage.getUserName(),"User");
        naptolHomePage.clickOnLogoutButton();
        Assert.assertTrue(naptolHomePage.loginOrRegisterDisplayed());

    }
}
