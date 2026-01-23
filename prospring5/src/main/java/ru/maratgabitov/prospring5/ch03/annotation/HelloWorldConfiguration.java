package ru.maratgabitov.prospring5.ch03.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageRenderer;

@ComponentScan(basePackages = {"ru.maratgabitov.prospring5.ch03.annotation"})
@Configuration
public class HelloWorldConfiguration {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
