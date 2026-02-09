package spring.ch04.javaconfigprop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import spring.ch04.javaconfig.ConfigurableMessageProvider;
import spring.ch04.javaconfig.MessageProvider;
import spring.ch04.javaconfig.MessageRenderer;
import spring.ch04.javaconfig.StandardOutMessageRenderer;

@Configuration
@PropertySource("classpath:spring/ch04/message.properties")
public class AppConfigOne {
    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean
    public MessageRenderer messageRenderer() {
        var renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());

        return renderer;
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfigOne.class);

        var renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();

        ctx.close();
    }
}
