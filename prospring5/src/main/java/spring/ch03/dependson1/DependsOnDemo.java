package spring.ch03.dependson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring.ch03.dependson1")
public class DependsOnDemo {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(DependsOnDemo.class);

        var johnMayer = ctx.getBean("johnMayer", Singer.class);
        johnMayer.sing();

        ctx.close();
    }
}
