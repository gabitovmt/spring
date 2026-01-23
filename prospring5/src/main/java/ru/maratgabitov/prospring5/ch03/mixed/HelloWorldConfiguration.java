package ru.maratgabitov.prospring5.ch03.mixed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageRenderer;

@ImportResource(locations = {"classpath:spring/app-context-xml.xml"})
@Configuration
public class HelloWorldConfiguration {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        var mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
