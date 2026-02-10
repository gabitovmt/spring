package spring.ch04.javaconfigscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.ch04.javaconfig.MessageProvider;
import spring.ch04.javaconfig.MessageRenderer;
import spring.ch04.javaconfig.StandardOutMessageRenderer;

@SuppressWarnings("all") // Код для учебных целей
@Configuration
@ComponentScan(basePackages = "spring.ch04.javaconfigscan")
public class AppConfigTwo {

    @Autowired
    private MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        var renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);

        return renderer;
    }
}
