package ru.maratgabitov.prospring5.ch03.annotated1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.maratgabitov.prospring5.ch02.decoupled.MessageProvider;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private final String message;

    @Autowired
    public ConfigurableMessageProvider(@Qualifier("message") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
