package ru.maratgabitov.prospring5.ch03.name2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ComponentScan(basePackages = "ru.maratgabitov.prospring5.ch03.name2")
@Configuration
public class AnnotatedBeanNaming {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AnnotatedBeanNaming.class);

        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);
        for (var id : beans.keySet()) {
            System.out.println("id: " + id);
        }

        ctx.close();
    }
}
