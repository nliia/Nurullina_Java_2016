package com.nurullina.b;

import static com.nurullina.c.SumDivide.sum;

/**
 * Created by Liia on 15.11.2016.
 */
public class ReverseSum {

    public static StringBuilder reverseSum(int a, int b) {
        int c = sum(a, b);
        StringBuilder sb = new StringBuilder();
        while (c > 9) {
            sb.append(c % 10);
            c = c / 10;
        }
        return sb.append(c);
    }
}
