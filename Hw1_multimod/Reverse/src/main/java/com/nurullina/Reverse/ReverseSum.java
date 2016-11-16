package com.nurullina.Reverse;

import static com.nurullina.ProcessNumbers.SumDivide.sum;

/**
 * Created by Liia on 15.11.2016.
 */
public class ReverseSum {

    public static String reverseSum(int a, int b) {
        int c = sum(a, b);
        StringBuilder sb = new StringBuilder();
        while (c > 9) {
            sb.append(c % 10);
            c = c / 10;
        }
        String result = String.valueOf(sb.append(c));
        return result;
    }
}
