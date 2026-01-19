package ru.maratgabitov.ch02.decoupled;

public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @SuppressWarnings("java:S106")
    @Override
    public void render() {
        if (messageProvider == null) {
            throw new NullPointerException(
                    "You must set the property messageProvider of class: " + StandardOutMessageRenderer.class.getName()
            );
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
