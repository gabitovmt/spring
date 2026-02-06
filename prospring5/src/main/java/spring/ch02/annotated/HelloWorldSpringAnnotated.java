package spring.ch02.annotated;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ch02.decoupled.MessageRenderer;

public class HelloWorldSpringAnnotated {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        ctx.close();
    }
}
