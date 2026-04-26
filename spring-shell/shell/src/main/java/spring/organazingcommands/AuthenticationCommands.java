package spring.organazingcommands;

import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;
import org.springframework.stereotype.Component;

@Component
@CommandGroup(name = "Authentication Commands", prefix = "auth")
public class AuthenticationCommands {
    private boolean authenticated = false;

    @Command(name = "login", description = "Log in to the system")
    public void login() {
        // Authentication logic here
        authenticated = true;
        System.out.println("Logged in successfully!");
    }

    @Command(name = "logout", description = "Log out of the system")
    public void logout() {
        // Logout logic here
        authenticated = false;
        System.out.println("Logged out successfully!");
    }
}
