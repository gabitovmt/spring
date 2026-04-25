package spring.support;

import org.springframework.shell.core.InputProvider;
import org.springframework.shell.core.InputReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StdInputProvider implements InputProvider {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final InputReader inputReader = new DefaultInputReader();

    @Override
    public String readInput() throws Exception {
        System.out.print("shell:> ");
        return reader.readLine();
    }

    public InputReader inputReader() {
        return inputReader;
    }

    public class DefaultInputReader implements InputReader {

        @Override
        public String readInput() throws Exception {
            return reader.readLine();
        }

        @Override
        public String readInput(String prompt) throws Exception {
            System.out.print("shell:> ");
            return readInput();
        }
    }
}
