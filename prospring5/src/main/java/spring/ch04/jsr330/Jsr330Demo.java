package spring.ch04.jsr330;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Jsr330Demo {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/jsr-330.xml");

        var renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();

        ctx.close();
    }
}
