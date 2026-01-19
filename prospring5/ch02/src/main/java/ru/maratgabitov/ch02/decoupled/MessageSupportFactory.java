package ru.maratgabitov.ch02.decoupled;

import java.util.Properties;

@SuppressWarnings("java:S6548") // Singleton выбран намеренно. Такой пример
public class MessageSupportFactory {
    private static final MessageSupportFactory INSTANCE = new MessageSupportFactory();

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
