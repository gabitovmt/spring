package ru.maratgabitov.prospring5.ch03.methodreplacement1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StandardLookupDemoBean implements DemoBean {
    private Singer mySinger;

    @SuppressWarnings("java:S6832") // Для учебных целей
    @Autowired
    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public Singer getMySinger() {
        return mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
