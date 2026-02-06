package spring.ch04.initbean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

public class SingerConfigDemo {

    @Configuration
    static class SingerConfig {

        @Lazy
        @Bean(initMethod = "init")
        Singer singerOne() {
            var singer = new Singer();
            singer.setName("John Mayer");
            singer.setAge(39);

            return singer;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerTwo() {
            var singer = new Singer();
            singer.setAge(72);

            return singer;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerThree() {
            var singer = new Singer();
            singer.setName("John Butler");

            return singer;
        }
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(SingerConfig.class);

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();
    }

    @SuppressWarnings("java:S106")
    private static Singer getBean(String beanName, ApplicationContext ctx) {
        try {
            var bean = ctx.getBean(beanName, Singer.class);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.err.println("An error occurred in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}
