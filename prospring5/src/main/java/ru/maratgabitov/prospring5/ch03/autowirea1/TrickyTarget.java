package ru.maratgabitov.prospring5.ch03.autowirea1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("gigi")
@Lazy
@SuppressWarnings("all") // Учебный код
public class TrickyTarget {

    public TrickyTarget() {
        System.out.println("TrickyTarget() called");
    }

    public TrickyTarget(Foo fooOne) {
        System.out.println("TrickyTarget(Foo) called");
    }

    public TrickyTarget(Foo fooOne, Bar bar) {
        System.out.println("TrickyTarget(Foo, Bar) called");
    }

    @Autowired
    public void setFooOne(Foo fooOne) {
        System.out.println("Property fooOne set");
    }

    @Autowired
    public void setFooTwo(Foo fooTwo) {
        System.out.println("Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar) {
        System.out.println("Property bar set");
    }

    @ComponentScan(basePackages = "ru.maratgabitov.prospring5.ch03.autowirea1")
    @Configuration
    public static class Config {
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);

        ctx.getBean(TrickyTarget.class);

        ctx.close();
    }
}
