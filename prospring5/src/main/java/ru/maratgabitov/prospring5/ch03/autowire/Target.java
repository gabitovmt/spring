package ru.maratgabitov.prospring5.ch03.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all") // код учебный
public class Target {
    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public Target() {
    }

    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("Property fooTwo set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/autowire.xml");

        System.out.println("Using byName:");
        ctx.getBean("targetByName", Target.class);

        System.out.println("\nUsing byType:");
        ctx.getBean("targetByType", Target.class);

        System.out.println("\nUsing constructor:");
        ctx.getBean("targetConstructor", Target.class);

        ctx.close();
    }
}
