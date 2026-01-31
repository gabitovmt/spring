package ru.maratgabitov.prospring5.ch04.destroybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.FileSystems;

public class DestructiveBeanConfigDemo {

    @Configuration
    static class DestructiveBeanConfig {

        @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destroy")
        DestructiveBean destructiveBean() {
            var bean = new DestructiveBean();
            bean.setFilePath(
                    System.getProperty("java.io.tmpdir")
                            + FileSystems.getDefault().getSeparator()
                            + "test.txt"
            );

            return bean;
        }
    }

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(DestructiveBeanConfig.class);

        ctx.getBean(DestructiveBean.class);

        System.out.println("Calling destroy()");
        ctx.close();
        System.out.println("called destroy()");
    }
}
