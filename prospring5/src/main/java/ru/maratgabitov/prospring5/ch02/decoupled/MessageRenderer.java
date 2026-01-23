package ru.maratgabitov.prospring5.ch02.decoupled;

import ru.maratgabitov.prospring5.ch02.decoupled.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
