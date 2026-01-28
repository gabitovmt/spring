package ru.maratgabitov.prospring5.ch03.inheritance;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InheritanceDemo {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/inheritance.xml");

        var parent = ctx.getBean("parent", Singer.class);
        var child = ctx.getBean("child", Singer.class);
        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);

        ctx.close();
    }
}
