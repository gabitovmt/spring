package ru.maratgabitov.prospring5.ch03;

public class BookwormOracle implements Oracle {
    @SuppressWarnings({"java:S1450", "java:S1068"})
    private Encyclopedia encyclopedia;

    public void setEncyclopedia(Encyclopedia encyclopedia) {
        this.encyclopedia = encyclopedia;
    }

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - go see the world instead";
    }
}
