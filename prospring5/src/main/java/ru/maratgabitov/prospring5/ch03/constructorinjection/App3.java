package ru.maratgabitov.prospring5.ch03.constructorinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageProvider;

public class App3 {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/constructor-injection-1.xml");
        var mp = ctx.getBean("provider", MessageProvider.class);
        System.out.println(mp.getMessage());
        ctx.close();
    }
}
