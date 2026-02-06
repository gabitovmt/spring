package spring.ch03.xml;

import spring.ch02.decoupled.MessageProvider;

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
