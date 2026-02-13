package spring.ch04.jsr330;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.Objects;

@Named("messageRenderer")
@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {

    @SuppressWarnings("java:S6813") // В учебных целях
    @Inject
    @Named("messageProvider")
    private MessageProvider messageProvider;

    @SuppressWarnings("java:S106")
    @Override
    public void render() {
        Objects.requireNonNull(messageProvider, "You must set the property messageProvider of class: " +
                StandardOutMessageRenderer.class.getName());
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
