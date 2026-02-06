package spring.ch04.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/event.xml");

        var pub = ctx.getBean("publisher", Publisher.class);
        pub.publish("I send an SOS to the world...");
        pub.publish("... I hope that someone gets my...");
        pub.publish("... Message in a bottle");

        ctx.close();
    }
}
