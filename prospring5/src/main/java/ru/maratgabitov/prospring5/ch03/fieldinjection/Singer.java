package ru.maratgabitov.prospring5.ch03.fieldinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("singer")
public class Singer {

    @SuppressWarnings("java:S6813")
    @Autowired
    private Inspiration inspiration;

    @SuppressWarnings("java:S106")
    public void sign() {
        System.out.println("... " + inspiration.getLyric());
    }
}
