package spring.ch04.javaconfigs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.ch04.javaconfig.MessageProvider;
import spring.ch04.javaconfig.MessageRenderer;
import spring.ch04.javaconfig.StandardOutMessageRenderer;

@SuppressWarnings("all")
@Configuration
@Import(AppConfigFour.class)
public class AppConfigThree {

    @Autowired
    private MessageProvider provider;

    @Bean
    public MessageRenderer messageRenderer() {
        var renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);

        return renderer;
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfigThree.class);
        ctx.getBean(MessageRenderer.class).render();
        ctx.close();
    }
}
