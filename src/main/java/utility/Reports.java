package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
    public static ExtentReports configureReports()
    {
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("extendsReports.html");
        ExtentReports extentReports=new  ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("TestType", "Regression");
        extentReports.setSystemInfo("Application", "Naapthol");
        extentReports.setSystemInfo("Author", "Kuldeep");


        return extentReports;
    }

}

