package spring.commandsyntax;

import org.springframework.shell.core.command.annotation.Arguments;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

@Component
public class ArgumentsWithArityCommands {

    /**
     * Real part of (a + bi)(c + di) = ac - bd
     */
    @Command(name = "real-part",
            description = "Calculate the real part of the product of two complex numbers",
            group = "math",
            help = "Calculate the real part of the product of two complex numbers. Example usage: real-part 1 2 3 4")
    public double realPartOfComplexProducts(
            @Arguments(arity = 2) double[] realParts,
            @Arguments(arity = 2) double[] imaginaryParts
    ) {
        return realParts[0] * realParts[1] - imaginaryParts[0] * imaginaryParts[1];
    }
}
