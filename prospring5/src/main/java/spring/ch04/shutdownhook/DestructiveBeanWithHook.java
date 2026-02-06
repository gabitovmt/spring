package spring.ch04.shutdownhook;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ch04.destroybean.DestructiveBean;

import java.nio.file.FileSystems;

public class DestructiveBeanWithHook {

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
        ctx.registerShutdownHook();
    }
}
