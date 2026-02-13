package spring.ch04.env;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class EnvironmentSampleFirst {

    @SuppressWarnings({"java:S106", "java:S1192"}) // В учебных целях
    public static void main(String[] args) {
        var ctx = new GenericApplicationContext();

        var env = ctx.getEnvironment();

        env.getPropertySources().addFirst(new MapPropertySource(
                "prospring5_MAP", Map.of("user.home", "application_home")
        ));

        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("user.home: " + env.getProperty("user.home"));

        ctx.close();
    }
}
