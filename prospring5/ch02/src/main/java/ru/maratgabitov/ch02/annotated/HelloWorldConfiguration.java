package ru.maratgabitov.ch02.annotated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.maratgabitov.ch02.decoupled.HelloWorldMessageProvider;
import ru.maratgabitov.ch02.decoupled.MessageProvider;
import ru.maratgabitov.ch02.decoupled.MessageRenderer;
import ru.maratgabitov.ch02.decoupled.StandardOutMessageRenderer;

@Configuration
public class HelloWorldConfiguration {

    // Равнозначно разметке <bean id="provider" class="..."/>
    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    // Равнозначно разметке <bean id="renderer" class="..."/>
    @Bean
    public MessageRenderer renderer() {
        var renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());

        return renderer;
    }
}
