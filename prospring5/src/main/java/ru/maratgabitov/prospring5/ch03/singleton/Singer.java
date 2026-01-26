package ru.maratgabitov.prospring5.ch03.singleton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("nonSingleton")
@Scope("prototype")
public class Singer {
    private final String name;

    public Singer(@Value("John Mayer") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
