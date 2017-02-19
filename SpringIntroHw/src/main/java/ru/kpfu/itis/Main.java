package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.config.JavaConfig;
import ru.kpfu.itis.entity.Restaurant;
import ru.kpfu.itis.entity.impl.RestaurantImpl;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        Restaurant restaurant = context.getBean("restaurant", Restaurant.class);
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Restaurant restaurant = context.getBean(Restaurant.class);
        restaurant.open();
    }
}
