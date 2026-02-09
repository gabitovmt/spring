package spring.ch04.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleOne {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        var renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();

        ctx.close();
    }
}
