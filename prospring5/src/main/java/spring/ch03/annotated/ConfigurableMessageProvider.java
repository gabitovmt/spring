package spring.ch03.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.ch02.decoupled.MessageProvider;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private final String message;

    @Autowired
    public ConfigurableMessageProvider(
            @Value("Configurable message") String message
    ) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
