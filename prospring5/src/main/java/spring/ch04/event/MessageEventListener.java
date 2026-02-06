package spring.ch04.event;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @SuppressWarnings("java:S106")
    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("Received: " + event.getMessage());
    }
}
