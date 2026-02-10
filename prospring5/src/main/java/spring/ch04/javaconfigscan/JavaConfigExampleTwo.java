package spring.ch04.javaconfigscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ch04.javaconfig.MessageRenderer;

public class JavaConfigExampleTwo {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfigTwo.class);
        ctx.getBean("messageRenderer", MessageRenderer.class).render();
        ctx.close();
    }
}
