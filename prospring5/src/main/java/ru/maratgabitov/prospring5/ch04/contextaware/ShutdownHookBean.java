package ru.maratgabitov.prospring5.ch04.contextaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        if (ctx instanceof ConfigurableApplicationContext genCtx) {
            genCtx.registerShutdownHook();
        }
    }
}
