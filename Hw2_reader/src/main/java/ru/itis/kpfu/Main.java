package ru.itis.kpfu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Liia on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Liia\\IdeaProjects\\Nurullina_Java_2016\\Hw2_reader\\src\\main\\java\\ru\\itis\\kpfu\\text.txt");
        InputStream is = new ChangeInputStream(new FileInputStream(file));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }
}
