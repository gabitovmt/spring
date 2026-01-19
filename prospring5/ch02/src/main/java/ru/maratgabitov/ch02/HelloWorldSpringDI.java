package ru.maratgabitov.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.maratgabitov.ch02.decoupled.MessageRenderer;

public class HelloWorldSpringDI {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
