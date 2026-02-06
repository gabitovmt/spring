package spring.ch04.contextaware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShutdownHookBeanDemo {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring/ch04/app-context-aware.xml");
        // Отсутствие закрытие контекста намеренно
    }
}
