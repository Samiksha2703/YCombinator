/**
 * purpose : To check the functionality of different features
 * Author : Samiksha Shende
 * Date : 08/06/2021
 */

package com.bridgelabz.ycombinator.test;

import com.bridgelabz.ycombinator.base.Base;
import com.bridgelabz.ycombinator.pages.Home;
import com.bridgelabz.ycombinator.utility.TestNgListener;
import com.bridgelabz.ycombinator.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestNgListener.class)
public class YCombinatorTest extends Base {
    Home home;
    String str = null;

    @Test(priority = 1)
    public void print_Title_With_Points() throws IOException {
        home = new Home(webdriver);
        Boolean check = home.printTitleWithPoints();
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("HomePageFirst")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("HomePageFirst")));
        }
        Assert.assertTrue(check);
    }

    @Test(priority = 2)
    public void whenGivenListOfNews_ShouldPrint_WordWhichOccursMaximumTime() throws IOException {
        home = new Home(webdriver);
        str = home.printWordOccursMaximum();
        if (str != null) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("HomePageSecond")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("HomePageSecond")));
        }
        Assert.assertNotEquals(str, null);
    }

    @Test(priority = 3)
    public void whenGivenListOfNews_WithMaximumOccurredWord_ShouldPrint_NewsWithMaximumPoints() throws IOException {
        home = new Home(webdriver);
        home.getListOfNewsWithCommonWords(str);
        Boolean check = home.printNewsWithMaximumPoints();
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("HomePageThird")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("HomePageThird")));
        }
        Assert.assertTrue(check);
    }

    @Test(priority = 4)
    public void whenGivenListOfNews_ShouldPrintNewsHeadline_WithMaximumPoints() throws IOException {
        home = new Home(webdriver);
        Boolean check = home.printNewsHeadlineWithMaximumPoint();
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("HomePageFourth")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("HomePageFourth")));
        }
        Assert.assertTrue(check);
    }
}
