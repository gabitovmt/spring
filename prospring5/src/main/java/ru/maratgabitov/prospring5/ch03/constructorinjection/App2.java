package ru.maratgabitov.prospring5.ch03.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageProvider;

@ComponentScan(basePackages = "ru.maratgabitov.prospring5.ch03.annotated")
@Configuration
public class App2 {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class);
        var mp = ctx.getBean("provider", MessageProvider.class);
        System.out.println(mp.getMessage());
    }
}
