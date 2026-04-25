package spring.support;

import org.springframework.shell.core.InputReader;
import org.springframework.shell.core.InteractiveShellRunner;
import org.springframework.shell.core.command.CommandParser;
import org.springframework.shell.core.command.CommandRegistry;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class StdShellRunner extends InteractiveShellRunner {
    private final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
    private final StdInputProvider inputProvider;

    public StdShellRunner(
            StdInputProvider inputProvider, CommandParser commandParser, CommandRegistry commandRegistry
    ) {
        super(inputProvider, commandParser, commandRegistry);
        this.inputProvider = inputProvider;
    }

    @Override
    public void print(String message) {
        try (PrintWriter outputWriter = writer) {
            outputWriter.println(message);
        }
    }

    @Override
    public void flush() {
        writer.flush();
    }

    @Override
    public PrintWriter getWriter() {
        return writer;
    }

    @Override
    public InputReader getReader() {
        return inputProvider.inputReader();
    }
}
