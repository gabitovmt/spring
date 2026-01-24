package ru.maratgabitov.prospring5.ch03.collections;

public class LyricHolder implements ContentHolder {
    private static final String VALUE = "'You be the DJ, I'll be the driver'";

    @Override
    public String toString() {
        return "LyricHolder: {" + VALUE + "}";
    }
}
