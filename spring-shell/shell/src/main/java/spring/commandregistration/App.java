package spring.commandregistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.shell.core.ShellRunner;
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
}
