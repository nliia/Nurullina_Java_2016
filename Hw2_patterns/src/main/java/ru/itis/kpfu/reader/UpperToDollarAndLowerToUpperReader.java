package ru.itis.kpfu.reader;

import java.io.*;

/**
 * Created by Liia on 16.11.2016.
 */
public class UpperToDollarAndLowerToUpperReader extends FilterReader {

    public UpperToDollarAndLowerToUpperReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : change(c);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return super.read(cbuf, off, len);
    }

    private int change(int c) {
        if (65 <= c && c <= 90) {
            return '$';
        }
        return Character.toUpperCase(c);
    }

}