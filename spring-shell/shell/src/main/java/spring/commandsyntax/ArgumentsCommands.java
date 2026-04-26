package spring.commandsyntax;

import org.springframework.shell.core.command.annotation.Arguments;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
public class ArgumentsCommands {

    @Command(name = "hello", description = "Say hi to given names", group = "greetings",
            help = "A command that greets users with a configurable suffix. " +
                    "Example usage: hello -s=! Foo Bar")
    public void sayHello(
            @Option(shortName = 's', longName = "suffix", description = "the suffix of the greeting message",
                    defaultValue = "!") String suffix,
            @Arguments String[] names
    ) {
        System.out.println("Hello " + String.join(", ", names) + suffix);
    }
}
