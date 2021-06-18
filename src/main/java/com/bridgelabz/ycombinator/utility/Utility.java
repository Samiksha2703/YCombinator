/**
 * purpose : To perform different functions
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */

package com.bridgelabz.ycombinator.utility;

import com.bridgelabz.ycombinator.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Utility extends Base {

    //method to get integer string from string
    public static String getIntString(String str) {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");
        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();
        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");
        return str;
    }

    //method to convert string into integer value
    public static int getIntValue(String str) {
        return Integer.parseInt(str);
    }

    //method to convert string into string array
    public static String[] getArrayOfString(String str) {
        String strArray[] = str.split(" ");
        return strArray;
    }

    //method to check internet connection
    public static void checkConnection() throws IOException {
        URL url = new URL("https://tpcindia.com/");
        URLConnection connection = url.openConnection();
        connection.connect();
        System.out.println("Internet is connected");
    }

    //Method to take a screenshot
    public static String screenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\kalam\\IdeaProjects\\YCombinatorAutomation\\src\\main\\resources\\Screenshot/" + fileName + System.currentTimeMillis() + ".jpg");
        String filePath = dest.getAbsolutePath();
        FileUtils.copyFile(file, dest);
        System.out.println("Screenshot Taken for " + fileName);
        return filePath;
    }
}
