package spring.ch04.javaconfigxml1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ch04.javaconfig.MessageRenderer;

public class JavaConfigExampleThree {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/java-config-xml-1.xml");
        ctx.getBean("messageRenderer", MessageRenderer.class).render();
        ctx.close();
    }
}
