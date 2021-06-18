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
    public static LinkedList<String> sortHeadlines = new LinkedList<>();
    public static HashMap<String, Integer> wordMap = new HashMap<>();
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
    public Boolean printTitleWithPoints() {
        try {
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
            for (int i = 0; i < points.size(); i++) {
                TitlePointHashMap.put(headlines.get(i), points.get(i));
            }
            int count = 1;
            for (Map.Entry<String, Integer> entry : TitlePointHashMap.entrySet())
                System.out.println("Headline : " + count++ + " " + entry.getKey() + "  Points : " + entry.getValue());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //get list of news with maximum occured word in it
    public void getListOfNewsWithCommonWords(String word) {
        for (int index = 0; index < headlines.size(); index++) {
            String strArray[] = Utility.getArrayOfString(headlines.get(index));
            for (int i = 0; i < strArray.length; i++) {
                if (word.equals(strArray[i])) {
                    sortHeadlines.add(headlines.get(index));
                }
            }
        }
    }

    //method to print news with maximum point with maximum occurred word in it
    public Boolean printNewsWithMaximumPoints() {
        try {
            int checkMaximum = 0;
            int maxIndex = 0;
            LinkedList<Integer> intList = new LinkedList<>();
            for (int i = 0; i < sortHeadlines.size(); i++) {
                intList.add(TitlePointHashMap.get(sortHeadlines.get(i)));
                for (int j = 0; j < intList.size(); j++) {
                    if (intList.get(j) > checkMaximum) {
                        maxIndex = j;
                        checkMaximum = intList.get(j);
                    }
                }
            }
            System.out.println("\nNews with maximum points with maximum occurrence word in it : \n" + sortHeadlines.get(maxIndex));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //method to print the word that occurs maximum time
    public String printWordOccursMaximum() {
        String str = null;
        for (int i = 0; i < headlines.size(); i++) {
            String strArray[] = Utility.getArrayOfString(headlines.get(i));
            //putting the key and value to hashmap
            for (int j = 0; j < strArray.length; j++) {
                if (wordMap.get(strArray[j]) == null) {
                    wordMap.put(strArray[j], 1);
                } else {
                    // System.out.println(strArray[j]+" "+wordMap.get(strArray[j]));
                    wordMap.put(strArray[j], wordMap.get(strArray[j]) + 1);
                }
            }
        }
        //to get value of hash map into array
        Integer[] intArray = wordMap.values().toArray(new Integer[0]);
        //sorting array
        Arrays.sort(intArray);
        //get the maximum value
        int max = intArray[intArray.length - 1];
        //to extract the key for value given
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue().equals(max)) {
                str = entry.getKey();
                System.out.println("\nWord that occurs for maximum time is : " + entry.getKey() + " And value is : " + entry.getValue());
            }
        }
        return str;
    }

    //method to print news headline with maximum points
    public Boolean printNewsHeadlineWithMaximumPoint() {
        try {
            Integer[] intArray = TitlePointHashMap.values().toArray(new Integer[0]);
            //sorting array
            Arrays.sort(intArray);
            //get the maximum value
            int max = intArray[intArray.length - 1];
            //to extract the key for value given
            for (Map.Entry<String, Integer> entry : TitlePointHashMap.entrySet()) {
                if (entry.getValue().equals(max)) {
                    System.out.println("\nNews headline with maximum points : " + entry.getKey() + "\nAnd points are : " + entry.getValue());
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}