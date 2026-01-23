package ru.maratgabitov.prospring5.ch03;

public class ConstructorInjection {
    private final Dependency dependency;

    public ConstructorInjection(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
