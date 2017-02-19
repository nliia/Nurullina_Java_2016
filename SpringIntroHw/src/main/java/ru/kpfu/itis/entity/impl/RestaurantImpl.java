package ru.kpfu.itis.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entity.Chef;
import ru.kpfu.itis.entity.Restaurant;
import ru.kpfu.itis.entity.Waiter;


public class RestaurantImpl implements Restaurant {
    Chef chef;
    Waiter waiter;

    @Autowired
    public RestaurantImpl(@Qualifier("japaneseChef") Chef chef, Waiter waiter) {
        this.chef = chef;
        this.waiter = waiter;
    }

    @Override
    public void open() {
        System.out.println("Restaurant opened");
        waiter.prepareOrder();
    }

    @Override
    public void close() {
        System.out.println("Restaurant closed");
    }
}
