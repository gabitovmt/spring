package ru.maratgabitov.prospring5.ch03.singleton;

public class Singleton {
    private static final Singleton INSTANCE;

    static {
        INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private Singleton() {}
}
