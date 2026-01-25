package ru.maratgabitov.prospring5.ch03.name;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest1 {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/name-1.xml");

        Map<String, String> beans = ctx.getBeansOfType(String.class);
        for (var n : beans.keySet()) {
            System.out.println(n);
        }

        ctx.close();
    }
}
