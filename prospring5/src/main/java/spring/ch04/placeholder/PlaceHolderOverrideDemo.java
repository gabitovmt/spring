package spring.ch04.placeholder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlaceHolderOverrideDemo {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/placeholder-override.xml");

        var appProperty = ctx.getBean("appProperty", AppProperty.class);
        System.out.println("application.home: " + appProperty.getApplicationHome());
        System.out.println("user.home: " + appProperty.getUserHome());

        ctx.close();
    }
}
