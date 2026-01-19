package ru.maratgabitov.ch02.decoupled;

import java.util.Properties;

public class MessageSupportFactory {
    private static final MessageSupportFactory INSTANCE;

    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        var props = new Properties();

        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));

            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static {
        INSTANCE = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return INSTANCE;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
