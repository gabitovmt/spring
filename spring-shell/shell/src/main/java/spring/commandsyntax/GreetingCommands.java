package spring.commandsyntax;

import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
public class GreetingCommands {

    @Command(name = "hi", description = "Say hi to a given name", group = "greetings",
            help = "A command that greets the user with 'Hi ${name}!' with a configurable suffix. " +
                    "Example usage: hi -s=! John")
    public void sayHi(
            @Argument(index = 0, description = "the name of the person to greet",
                    defaultValue = "world") String name,
            @Option(shortName = 's', longName = "suffix", description = "the suffix of the greeting message",
                    defaultValue = "!") String suffix
    ) {
        System.out.println("Hi " + name + suffix);
    }
}
