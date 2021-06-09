/**
 * purpose : To perform different operations of Bookswagon Application
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */

package com.bridgelabz.ycombinator.pages;

import com.bridgelabz.ycombinator.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class Home {
    public static LinkedList<String> headlines = new LinkedList<>();
    public static LinkedList<Integer> points = new LinkedList<>();
    public static HashMap<String, Integer> TitlePointHashMap = new HashMap<>();
    @FindBy(xpath = "//a[@class='morelink']")
    WebElement moreButton;

    @FindBy(className = "storylink")
    List<WebElement> newsTitle;

    @FindBy(className = "score")
    List<WebElement> newsPoints;

    public Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //method to get news and print it on console
    public void printTitleWithPoints() {
        int newsCount = 30;
        while (newsCount <= 120) {
            Iterator<WebElement> titleItr = newsTitle.iterator();
            while (titleItr.hasNext()) {
                String text = titleItr.next().getText();
                headlines.add(text);
            }
            Iterator<WebElement> pointsItr = newsPoints.iterator();
            while (pointsItr.hasNext()) {
                String text = pointsItr.next().getText();
                String str = Utility.getIntString(text);
                int intValue = Utility.getIntValue(str);
                points.add(intValue);
            }
            moreButton.click();
            newsCount += 30;
        }
        for (int i = 0; i < headlines.size(); i++) {
            TitlePointHashMap.put(headlines.get(i), points.get(i));
        }
        for (Map.Entry<String, Integer> entry: TitlePointHashMap.entrySet())
            System.out.println("Headline : "+entry.getKey()+"  Points : "+entry.getValue());
    }
}

