package spring.ch03.mixed;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import spring.ch02.decoupled.MessageRenderer;

@ImportResource(locations = {"classpath:spring/ch03/app-context-xml.xml"})
@Configuration
public class HelloWorldConfiguration {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        ctx.close();
    }
}
