package ru.maratgabitov.prospring5.ch03.fieldinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "ru.maratgabitov.prospring5.ch03.fieldinjection")
@Configuration
public class App {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(App.class);
        var singer = ctx.getBean("singer", Singer.class);
        singer.sign();
        ctx.close();
    }
}
