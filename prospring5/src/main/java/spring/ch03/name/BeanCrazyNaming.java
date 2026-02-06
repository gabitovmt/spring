package spring.ch03.name;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class BeanCrazyNaming {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/crazy-naming.xml");

        var beans = ctx.getBeansOfType(String.class);
        for (var id : beans.keySet()) {
            System.out.printf("id: %s%n aliases: %s%n", id, Arrays.toString(ctx.getAliases(id)));
        }

        ctx.close();
    }
}
