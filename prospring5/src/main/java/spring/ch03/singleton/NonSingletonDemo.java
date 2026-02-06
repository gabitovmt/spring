package spring.ch03.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NonSingletonDemo {

    public static void main(String[] args) {
        var ctx1 = new ClassPathXmlApplicationContext("spring/ch03/prototype.xml");
        test(ctx1);
        ctx1.close();

        var ctx2 = new AnnotationConfigApplicationContext(Singer.class);
        test(ctx2);
        ctx2.close();
    }

    @SuppressWarnings("java:S106")
    private static void test(ApplicationContext ctx) {
        var singer1 = ctx.getBean("nonSingleton", Singer.class);
        var singer2 = ctx.getBean("nonSingleton", Singer.class);
        System.out.println("Identity Equal?: " + (singer1 == singer2));
        System.out.println("Value Equal?: " + singer1.equals(singer2));
        System.out.println(singer1);
        System.out.println(singer2);
    }
}
