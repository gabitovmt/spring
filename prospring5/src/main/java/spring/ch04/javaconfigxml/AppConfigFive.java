package spring.ch04.javaconfigxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import spring.ch04.javaconfig.MessageProvider;
import spring.ch04.javaconfig.MessageRenderer;
import spring.ch04.javaconfig.StandardOutMessageRenderer;

@SuppressWarnings("all")
@Configuration
@ImportResource("classpath:spring/ch04/java-config-xml.xml")
public class AppConfigFive {

    @Autowired
    private MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        var renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);

        return renderer;
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfigFive.class);
        ctx.getBean("messageRenderer", MessageRenderer.class).render();
        ctx.close();
    }
}
