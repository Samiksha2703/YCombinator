/**
 * purpose : To create setup to run before and after test cases
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */


package com.bridgelabz.ycombinator.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver webdriver;

    //method to launch browser
    @BeforeTest
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            URL url = new URL("https://news.ycombinator.com/newest");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
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
}
