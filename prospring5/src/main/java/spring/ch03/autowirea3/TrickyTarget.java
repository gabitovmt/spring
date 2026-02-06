package spring.ch03.autowirea3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all") // Учебный код
public class TrickyTarget {

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

    @ComponentScan(basePackages = "spring.ch03.autowirea3")
    @Configuration
    public static class Config {
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);

        ctx.getBean(TrickyTarget.class);

        ctx.close();
    }
}
