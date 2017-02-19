package ru.kpfu.itis.entity.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entity.Order;

@Component
@Scope("prototype")
public class OrderImpl implements Order {

    @Override
    public void prepare() {
        System.out.println("Order is being prepared");
    }

}
