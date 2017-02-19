package ru.kpfu.itis.entity;

import org.springframework.beans.factory.FactoryBean;
import ru.kpfu.itis.entity.impl.TrayImpl;

public class TrayFactory implements FactoryBean<Tray> {
    private String size;

    @Override
    public Tray getObject() throws Exception {
        Tray tray = new TrayImpl();
        if (size != null)
            tray.setSize(size);
        return tray;
    }

    @Override
    public Class<?> getObjectType() {
        return Tray.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


    public void setSize(String size) {
        this.size = size;
    }
}
