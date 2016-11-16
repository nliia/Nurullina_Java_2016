package com.nurullina.Reverse;


import static com.nurullina.ProcessNumbers.MathMethods.sum;

/**
 * Created by Liia on 15.11.2016.
 */
public class ReverseSum {

    public static String reverseSum(int a, int b) {
        int c = sum(a, b);
        StringBuilder reverseNumber = new StringBuilder();
        while (c > 9) {
            reverseNumber.append(c % 10);
            c = c / 10;
        }

        return reverseNumber.append(c).toString();
    }
}
