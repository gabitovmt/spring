package spring.ch04.javaconfig;

@SuppressWarnings("java:S106")
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public StandardOutMessageRenderer() {
        System.out.println(" --> StandardOutMessageRenderer: constructor called");
    }

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new IllegalStateException("You must set the property messageProvider of class: "
                    + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        System.out.println(" --> StandardOutMessageRenderer: setting the provider");
        messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
