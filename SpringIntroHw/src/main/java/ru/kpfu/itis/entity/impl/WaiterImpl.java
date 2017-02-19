package ru.kpfu.itis.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entity.Chef;
import ru.kpfu.itis.entity.Order;
import ru.kpfu.itis.entity.Tray;
import ru.kpfu.itis.entity.Waiter;

@Component
public class WaiterImpl implements Waiter {
    Order order;
    Tray tray;
    Chef chef;

    @Autowired
    public WaiterImpl(Tray tray, @Qualifier("japaneseChef") Chef chef) {
        this.tray = tray;
        this.chef = chef;
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public void prepareOrder() {
        if (tray.getSize().equals("small"))
            System.out.println("Waiter's tray is small");
        else
            System.out.println("Waiter's tray is big");
        chef.cookOrder(order);
    }
}
