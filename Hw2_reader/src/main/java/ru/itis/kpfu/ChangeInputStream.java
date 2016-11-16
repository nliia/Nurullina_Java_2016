package ru.itis.kpfu;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Liia on 16.11.2016.
 */
public class ChangeInputStream extends FilterInputStream {

    public ChangeInputStream(InputStream in) {
        super(in);
    }


    @Override
    public int read() throws IOException {
       int c = super.read();
        return c == -1? c : change(c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    private int change(int c){

        if(65 <= c && c <=90){
            return '$';
        }
        return Character.toUpperCase(c);
    }

}
