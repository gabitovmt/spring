package ru.maratgabitov.prospring5.ch03.xml;

import ru.maratgabitov.prospring5.ch02.decoupled.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {
    private final String message;

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
