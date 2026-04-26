package spring.commandregistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.shell.core.ShellRunner;
import org.springframework.shell.core.command.AbstractCommand;
import org.springframework.shell.core.command.Command;
import org.springframework.shell.core.command.CommandContext;
import org.springframework.shell.core.command.ExitStatus;
import org.springframework.shell.core.command.annotation.EnableCommand;
import spring.support.ShellRunnerConfig;

@Import(ShellRunnerConfig.class)
@ComponentScan
@EnableCommand(MyCommands.class)
public class App {

    public static void main(String[] args) throws Exception {
        var ctx = new AnnotationConfigApplicationContext(App.class);
        var runner = ctx.getBean(ShellRunner.class);
        runner.run(args);
    }

    @Bean
    Command foo() {
        return Command.builder().name("foo").execute(context -> {
            context.outputWriter().println("FOO");
        });
    }

    @Bean
    Command bar() {
        return new AbstractCommand("bar", "This is bar command") {
            @Override
            public ExitStatus doExecute(CommandContext commandContext) {
                println("BAR", commandContext);
                return ExitStatus.OK;
            }
        };
    }
}
