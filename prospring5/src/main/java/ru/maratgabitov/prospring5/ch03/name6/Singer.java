package ru.maratgabitov.prospring5.ch03.name6;

import org.springframework.stereotype.Component;
import ru.maratgabitov.prospring5.ch03.name5.Trophy;

@Component("johnMayer")
@Trophy(name = {"grammy", "platinum disk"})
public class Singer {
    private static final String LYRIC = "We found a message in a bottle we were drinking";

    @SuppressWarnings("java:S106")
    public void sing() {
        System.out.println(LYRIC);
    }
}
