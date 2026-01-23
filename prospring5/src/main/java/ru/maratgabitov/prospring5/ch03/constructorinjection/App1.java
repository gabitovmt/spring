package ru.maratgabitov.prospring5.ch03.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageProvider;

public class App1 {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ch03/constructor-injection.xml");
        var mp1 = ctx.getBean("messageProvider", MessageProvider.class);
        var mp2 = ctx.getBean("anotherMessageProvider", MessageProvider.class);
        System.out.println(mp1.getMessage());
        System.out.println(mp2.getMessage());
    }
}
