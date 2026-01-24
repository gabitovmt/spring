package ru.maratgabitov.prospring5.ch03.methodreplacement;

public class Singer {
    private static final String LYRIC = "I played a quick game of chess with the salt and pepper shaker";

    @SuppressWarnings("java:S106")
    public void sing() {
        System.out.println(LYRIC);
    }
}
