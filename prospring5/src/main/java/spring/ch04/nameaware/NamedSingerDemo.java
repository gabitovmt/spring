package spring.ch04.nameaware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NamedSingerDemo {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(NamedSinger.class);

        var singer = ctx.getBean(NamedSinger.class);
        singer.sing();

        ctx.close();
    }
}
