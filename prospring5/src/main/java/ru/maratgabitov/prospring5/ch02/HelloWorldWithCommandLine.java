package ru.maratgabitov.prospring5.ch02;

public class HelloWorldWithCommandLine {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello World!");
        }
    }
}
