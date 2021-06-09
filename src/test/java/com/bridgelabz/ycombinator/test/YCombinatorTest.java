/**
 * purpose : To check the functionality of different features
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */

package com.bridgelabz.ycombinator.test;

import com.bridgelabz.ycombinator.base.Base;
import com.bridgelabz.ycombinator.pages.Home;
import org.testng.annotations.Test;

public class YCombinatorTest extends Base {
    Home home;

    @Test(priority = 1)
    public void print_Title_With_Points() {
        home = new Home(webdriver);
        home.printTitleWithPoints();
    }
}
