/**
 * purpose : To create setup to run before and after test cases
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */


package com.bridgelabz.ycombinator.base;

import com.bridgelabz.ycombinator.utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver webdriver;
    public static ExtentTest test;
    static ExtentReports report;
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    //method to launch browser
    @BeforeTest
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();
        threadLocal.set(webdriver);
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Utility.checkConnection();
            // launch application
            webdriver.get("https://news.ycombinator.com/newest");
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    //method to close the session open by driver
    @AfterTest
    public void tearDown() {
        webdriver.close();
    }

    //method to run before class to generate extent report
    @BeforeClass
    public static void startTest() {
        report = new ExtentReports("C:\\Users\\kalam\\IdeaProjects\\YCombinatorAutomation\\src\\main\\resources\\ExtentReport\\" + "ExtentReportResults.html");
        test = report.startTest("Bookswagon Extent Report");
    }

    //method to run after class to generate extent report
    @AfterClass
    public static void endTest() {
        report.endTest(test);
        report.flush();
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }
}
