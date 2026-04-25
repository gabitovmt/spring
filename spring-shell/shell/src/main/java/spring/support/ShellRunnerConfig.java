package spring.support;

import org.springframework.context.annotation.Bean;
import org.springframework.shell.core.ShellRunner;
import org.springframework.shell.core.command.CommandParser;
import org.springframework.shell.core.command.CommandRegistry;

public class ShellRunnerConfig {

    @Bean
    public ShellRunner shellRunner(CommandParser commandParser, CommandRegistry commandRegistry) {
        return new StdShellRunner(new StdInputProvider(), commandParser, commandRegistry);
    }
}
