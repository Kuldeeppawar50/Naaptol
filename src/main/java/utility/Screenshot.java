package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {
       public static void takeScreenShot(WebDriver driver, String name) throws IOException {
         File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         File destination = new File("E:\\Screenshot\\"+name+".jpg");
         FileHandler.copy(source, destination);
     }

}
