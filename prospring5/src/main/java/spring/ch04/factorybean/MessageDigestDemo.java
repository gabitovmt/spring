package spring.ch04.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageDigestDemo {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/factory-bean.xml");

        var digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");

        ctx.close();
    }
}
