package spring.ch03.name;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/name.xml");

        Map<String, String> beans = ctx.getBeansOfType(String.class);
        for (var n : beans.keySet()) {
            System.out.println(n);
        }

        ctx.close();
    }
}
