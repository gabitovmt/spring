package ru.maratgabitov.prospring5.ch03.dependson;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependsOnDemo {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/depends-on.xml");

        var johnMayer = ctx.getBean("johnMayer", Singer.class);
        johnMayer.sing();

        ctx.close();
    }
}
