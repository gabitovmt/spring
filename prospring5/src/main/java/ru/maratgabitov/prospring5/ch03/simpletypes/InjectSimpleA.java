package ru.maratgabitov.prospring5.ch03.simpletypes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S6804")
@Service
public class InjectSimpleA {
    @Value("John Mayer")
    private String name;
    @Value("39")
    private int age;
    @Value("1.92")
    private float height;
    @Value("false")
    private boolean programmer;
    @Value("1241401112")
    private Long ageInSeconds;

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(InjectSimpleA.class);
        System.out.println(ctx.getBean(InjectSimpleA.class));
        ctx.close();
    }

    @Override
    public String toString() {
        return "InjectSimpleA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
