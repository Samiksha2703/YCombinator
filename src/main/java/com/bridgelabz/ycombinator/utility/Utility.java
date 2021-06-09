/**
 * purpose : To perform different functions
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */

package com.bridgelabz.ycombinator.utility;

import java.sql.Array;

public class Utility {

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
    public static String[] getArrayOfString(String str){
        String strArray[] = str.split(" ");
        return strArray;
    }
}
