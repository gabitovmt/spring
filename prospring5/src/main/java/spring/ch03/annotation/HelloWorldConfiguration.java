package spring.ch03.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.ch02.decoupled.MessageRenderer;

@ComponentScan(basePackages = {"spring.ch03.annotation"})
@Configuration
public class HelloWorldConfiguration {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        ctx.close();
    }
}
