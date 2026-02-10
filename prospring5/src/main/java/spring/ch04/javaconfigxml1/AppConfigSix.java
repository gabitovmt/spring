package spring.ch04.javaconfigxml1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ch04.javaconfig.ConfigurableMessageProvider;
import spring.ch04.javaconfig.MessageProvider;

@Configuration
public class AppConfigSix {

    @Bean
    public MessageProvider provider() {
        return new ConfigurableMessageProvider("Love on the weekend");
    }
}
