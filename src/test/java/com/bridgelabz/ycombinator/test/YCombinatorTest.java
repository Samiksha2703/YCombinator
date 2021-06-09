/**
 * purpose : To check the functionality of different features
 * Author : Samiksha Shende
 * Date : 08/06/2021
 */

package com.bridgelabz.ycombinator.test;

import com.bridgelabz.ycombinator.base.Base;
import com.bridgelabz.ycombinator.pages.Home;
import org.testng.annotations.Test;

public class YCombinatorTest extends Base {
    Home home;
    String str = null;

    @Test(priority = 1)
    public void print_Title_With_Points() {
        home = new Home(webdriver);
        home.printTitleWithPoints();
    }

    @Test(priority = 2)
    public void whenGivenListOfNews_ShouldPrint_WordWhichOccursMaximumTime() {
        home = new Home(webdriver);
        str = home.printWordOccursMaximum();
    }

    @Test(priority = 3)
    public void whenGivenListOfNews_WithMaximumOccurredWord_ShouldPrint_NewsWithMaximumPoints() {
        home = new Home(webdriver);
        home.getListOfNewsWithCommonWords(str);
        home.printNewsWithMaximumPoints();
    }

    @Test(priority = 4)
    public void whenGivenListOfNews_ShouldPrintNewsHeadline_WithMaximumPoints() {
        home = new Home(webdriver);
        home.printNewsHeadlineWithMaximumPoint();
    }
}
