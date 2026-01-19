package ru.maratgabitov.ch02.decoupled;

public class HelloWorldDecoupledWithFactory {

    public static void main(String[] args) {
        var mr = MessageSupportFactory.getInstance().getMessageRenderer();
        var mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
