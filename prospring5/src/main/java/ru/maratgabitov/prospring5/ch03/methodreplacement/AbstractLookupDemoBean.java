package ru.maratgabitov.prospring5.ch03.methodreplacement;

public abstract class AbstractLookupDemoBean implements DemoBean {

    @Override
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
