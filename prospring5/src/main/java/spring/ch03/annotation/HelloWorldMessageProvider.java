package spring.ch03.annotation;

import org.springframework.stereotype.Component;
import spring.ch02.decoupled.MessageProvider;

// Простой компонент Spring Bean
@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
