package spring.ch03.confused;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App1 {

    public static void main(String[] args) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch03/constructor-confusion.xml");
        ctx.refresh();
        ctx.close();
    }
}
