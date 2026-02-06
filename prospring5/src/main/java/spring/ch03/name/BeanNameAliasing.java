package spring.ch03.name;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class BeanNameAliasing {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/alias.xml");

        var s1 = ctx.getBean("john");
        var s2 = ctx.getBean("jon");
        var s3 = ctx.getBean("johnny");
        var s4 = ctx.getBean("jonathan");
        var s5 = ctx.getBean("jim");
        var s6 = ctx.getBean("ion");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
        System.out.println(s5 == s6);

        Map<String, String> beans = ctx.getBeansOfType(String.class);
        if (beans.size() == 1) {
            System.out.println("There is only one String bean.");
        }

        ctx.close();
    }
}
