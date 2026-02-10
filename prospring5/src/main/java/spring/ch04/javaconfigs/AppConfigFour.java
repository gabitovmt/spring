package spring.ch04.javaconfigs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring.ch04.javaconfigscan")
public class AppConfigFour {
}
