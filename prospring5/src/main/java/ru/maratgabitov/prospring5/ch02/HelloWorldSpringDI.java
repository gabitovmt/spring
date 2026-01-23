package ru.maratgabitov.prospring5.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageRenderer;

public class HelloWorldSpringDI {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
