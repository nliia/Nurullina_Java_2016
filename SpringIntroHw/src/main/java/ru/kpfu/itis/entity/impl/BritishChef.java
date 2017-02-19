package ru.kpfu.itis.entity.impl;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.entity.Chef;
import ru.kpfu.itis.entity.Order;

@Component
public class BritishChef implements Chef {

    @Override
    public void cookOrder(Order order) {
        order.prepare();
        System.out.println("Order is ready");
    }
}
