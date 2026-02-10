package spring.ch04.javaconfigscan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.ch04.javaconfig.MessageProvider;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private final String message;

    public ConfigurableMessageProvider(@Value("Love on the weekend") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
