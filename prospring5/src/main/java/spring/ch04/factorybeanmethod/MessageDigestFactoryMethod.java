package spring.ch04.factorybeanmethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ch04.factorybean.MessageDigester;

public class MessageDigestFactoryMethod {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/factory-bean-method.xml");

        var digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");

        ctx.close();
    }
}
