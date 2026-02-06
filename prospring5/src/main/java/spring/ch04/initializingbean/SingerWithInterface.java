package spring.ch04.initializingbean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingerWithInterface implements InitializingBean {
    public static final String DEFAULT_NAME = "Eric Clapton";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @SuppressWarnings("java:S106")
    @Override
    public void afterPropertiesSet() {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Age must set the age property of any beans of type " + SingerWithInterface.class
            );
        }
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/initializing-bean.xml");

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();
    }

    @SuppressWarnings("java:S106")
    private static SingerWithInterface getBean(String beanName, ApplicationContext ctx) {
        try {
            var bean = ctx.getBean(beanName, SingerWithInterface.class);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.err.println("An error occurred in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}
