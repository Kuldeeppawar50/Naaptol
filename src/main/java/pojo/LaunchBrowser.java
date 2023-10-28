package pojo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static WebDriver openBrowser(String url){
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "E:\\automation-selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.naaptol.com/");
        driver.manage().window().maximize();
        return driver;
    }
}


