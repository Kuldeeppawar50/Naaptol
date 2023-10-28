import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.Screenshot;

import java.io.IOException;

public class Listners extends Basic implements ITestListener {
    public void onTestStart(ITestResult result){
        System.out.println("on test start :- " +result.getName());
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("on test success :- " + result.getName());
    }
    public void onTestFailure(ITestResult result) {
//        System.out.println("on test failure :- " + result.getName());
        try {
            Screenshot.takeScreenShot(driver,result.getName());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("on test skipped :- " + result.getName());
    }
    public void onTestFinish(ITestResult result) {
        System.out.println("on test finish :- " + result.getName());
    }

}
