package ru.maratgabitov.prospring5.ch03.autowiretype;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all") // код учебный
public class CTarget {
    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public CTarget() {
    }

    public CTarget(Foo foo) {
        System.out.println("Target(Foo) called");
    }

    public CTarget(Foo foo, Bar bar) {
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
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/autowire-type.xml");

        System.out.println("\nUsing byType:");
        ctx.getBean("targetByType", CTarget.class);

        ctx.close();
    }
}
