package spring.ch03.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import spring.ch02.decoupled.MessageRenderer;

public class DeclareSpringComponents {

    public static void main(String[] args) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch03/app-context-annotation.xml");
        ctx.refresh();
        var messageRenderer = ctx.getBean("renderer", MessageRenderer.class);
        messageRenderer.render();
        ctx.close();
    }
}
