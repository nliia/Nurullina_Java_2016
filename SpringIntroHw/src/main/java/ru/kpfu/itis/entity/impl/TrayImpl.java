package ru.kpfu.itis.entity.impl;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.entity.Tray;

@Component
public class TrayImpl implements Tray {
    public String size;

    @Override
    public void clean() {
        System.out.println("The tray is cleaned");
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getSize() {
        return size;
    }
}
