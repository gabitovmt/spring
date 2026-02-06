package spring.ch04.factorybean1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ch04.factorybean.MessageDigestFactoryBean;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;

public class AccessingFactoryBeans {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/factory-bean.xml");

        var factoryBean = ctx.getBean("&shaDigest", MessageDigestFactoryBean.class);
        MessageDigest shaDigest = Objects.requireNonNull(factoryBean.getObject());
        var hash = shaDigest.digest("Hello World".getBytes());
        System.out.println(Arrays.toString(hash));

        ctx.close();
    }
}
