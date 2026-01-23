package ru.maratgabitov.prospring5.ch03.confused;

public class ConstructorConfusionXml {
    private final String someValue;

    @SuppressWarnings("java:S106")
    public ConstructorConfusionXml(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    @SuppressWarnings("java:S106")
    public ConstructorConfusionXml(int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    @Override
    public String toString() {
        return someValue;
    }
}
