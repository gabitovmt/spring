package spring.organazingcommands;

import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

@Component
public class MyCommands {

    @Command(name = "example", group = "My Commands")
    public String example() {
        return "Hello";
    }
}
