package ru.kpfu.itis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.kpfu.itis.entity.*;
import ru.kpfu.itis.entity.impl.*;

@Configuration
public class JavaConfig {

    @Bean
    public Chef britishChef() {
        Chef chef = new BritishChef();
        return chef;
    }

    @Bean
    public Chef JapaneseChef() {
        Chef chef = new JapaneseChef();
        return chef;
    }

    @Bean
    @Scope("prototype")
    public Order order() {
        Order order = new OrderImpl();
        return order;
    }

    @Bean
    public Waiter waiter() {
        Waiter waiter = new WaiterImpl(bigTray(), britishChef());
        waiter.setOrder(order());
        return waiter;
    }

    @Bean
    public Tray smallTray() {
        TrayImpl tray = new TrayImpl();
        tray.setSize("small");
        return tray;
    }

    @Bean
    public Tray bigTray() {
        TrayImpl tray = new TrayImpl();
        tray.setSize("big");
        return tray;
    }

    @Bean
    public Restaurant restaurant(){
        Restaurant restaurant = new RestaurantImpl(britishChef(), waiter());
        return restaurant;

    }
}
