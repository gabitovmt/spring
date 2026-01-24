package ru.maratgabitov.prospring5.ch03.ref;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.maratgabitov.prospring5.ch03.ex02.Oracle;

public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    @Override
    public String toString() {
        return oracle.defineMeaningOfLife();
    }

    public static void main(String[] args) {
        run("classpath:spring/ch03/ref-1.xml");
        run("classpath:spring/ch03/ref-2.xml");
    }

    @SuppressWarnings("java:S106")
    private static void run(String resourceLocation) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load(resourceLocation);
        ctx.refresh();

        var injectRef = ctx.getBean("injectRef", InjectRef.class);
        System.out.println(injectRef);

        ctx.close();
    }
}
