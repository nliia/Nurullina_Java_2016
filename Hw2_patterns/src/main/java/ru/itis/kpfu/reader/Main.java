package ru.itis.kpfu.reader;

import java.io.*;

/**
 * Created by Liia on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        Reader is = new ChangeReader(new FileReader(file));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }
}
