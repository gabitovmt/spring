package ru.maratgabitov.prospring5.ch03.methodreplacement1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Singer {

    public void sing() {
        // Здесь должен быть вывод на консоль текста
        // "I played a quick game of chess with the salt and pepper shaker"
        // но он не реализован, чтобы не забивать консоль
    }
}
