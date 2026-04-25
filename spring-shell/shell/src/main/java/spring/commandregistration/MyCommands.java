package spring.commandregistration;

import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

@Component
public class MyCommands {

    @Command(name = "example")
    public String example() {
        return "Hello";
    }
}
