package ru.maratgabitov.prospring5.ch03.autowirea5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class TargetDemo {

    @Configuration
    static class TargetConfig {

        @Bean
        public Foo fooImplOne() {
            return new FooImplOne();
        }

        @Bean
        public Foo fooImplTwo() {
            return new FooImplTwo();
        }

        @Bean
        public Bar bar() {
            return new Bar();
        }

        @Bean
        public TrickyTarget trickyTarget() {
            return new TrickyTarget();
        }
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(TargetConfig.class);

        ctx.getBean(TrickyTarget.class);

        ctx.close();
    }
}
