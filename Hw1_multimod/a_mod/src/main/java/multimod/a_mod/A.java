package multimod.a_mod;

import static multimod.b_mod.B.reverseSum;
import static multimod.c_mod.C.divide;

/**
 * Created by Liia on 15.11.2016.
 */
public class A {
    public static void main(String[] args) {
        System.out.println("Reversed sum of numbers:" + reverseSum(15, 25));
        System.out.println("Division:" + divide(30, 15));
    }
}
