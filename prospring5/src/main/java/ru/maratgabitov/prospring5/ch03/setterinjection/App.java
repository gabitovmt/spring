package ru.maratgabitov.prospring5.ch03.setterinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageRenderer;

public class App {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/setter-injection.xml");
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        ctx.close();
    }
}
