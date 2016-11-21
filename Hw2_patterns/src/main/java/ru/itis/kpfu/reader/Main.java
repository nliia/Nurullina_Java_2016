package ru.itis.kpfu.reader;

import java.io.*;
/**
 * Created by Liia on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Reader is = new UpperToDollarAndLowerToUpperReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("text.txt")));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }
}