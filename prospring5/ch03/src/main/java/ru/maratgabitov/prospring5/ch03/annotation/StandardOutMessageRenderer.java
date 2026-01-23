package ru.maratgabitov.prospring5.ch03.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageProvider;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageRenderer;

// Сложный служебный компонент Spring Bean
@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @SuppressWarnings("java:S106")
    @Override
    public void render() {
        if (messageProvider == null) {
            throw new NullPointerException("You must set the property messageProvider of class: " +
                    StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Autowired
    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
