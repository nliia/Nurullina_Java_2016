package com.nurullina.a;

import static com.nurullina.Reverse.ReverseSum.reverseSum;
import static com.nurullina.ProcessNumbers.SumDivide.divide;

/**
 * Created by Liia on 15.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Reversed sum of numbers:" + reverseSum(15, 25));
        System.out.println("Division:" + divide(30, 15));
    }
}