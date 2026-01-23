package ru.maratgabitov.prospring5.ch03.confused;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ru.maratgabitov.prospring5.ch03.confused")
public class App2 {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(App2.class);
        ctx.close();
    }
}
