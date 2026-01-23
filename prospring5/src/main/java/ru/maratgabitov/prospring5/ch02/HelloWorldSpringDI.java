package ru.maratgabitov.prospring5.ch02;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageRenderer;

public class HelloWorldSpringDI {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch02/app-context.xml");
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        ctx.close();
    }
}
