package spring.ch03.name4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ch03.name1.Singer;

import java.util.Arrays;

public class AliasConfigDemo {

    @Configuration
    public static class AliasBeanConfig {
        @Bean(name = {"johnMayer", "john", "jonathan", "johnny"})
        public Singer singer() {
            return new Singer();
        }
    }

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AliasBeanConfig.class);

        var beans = ctx.getBeansOfType(Singer.class);
        for (var beanId : beans.keySet()) {
            System.out.printf("id: %s%n aliases: %s%n", beanId, Arrays.toString(ctx.getAliases(beanId)));
        }

        ctx.close();
    }
}
