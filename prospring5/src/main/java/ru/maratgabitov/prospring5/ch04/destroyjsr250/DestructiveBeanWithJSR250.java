package ru.maratgabitov.prospring5.ch04.destroyjsr250;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.maratgabitov.prospring5.ch04.destroymethod.DestructiveBean;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("java:S106")
public class DestructiveBeanWithJSR250 {
    private File file;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @PostConstruct
    public void afterPropertiesSet() throws IOException {
        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
        }

        file = new File(filePath);
        if (!file.createNewFile()) {
            System.err.println("ERROR: failed to create new file");
        }
        System.out.println("File exists: " + file.exists());
    }

    @SuppressWarnings("java:S4042") // Учебный код
    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file");
        }

        System.out.println("File exists: " + file.exists());
    }

    public static void main(String[] args) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch04/destroy-jsr-250.xml");
        ctx.refresh();

        ctx.getBean("destructiveBean", DestructiveBeanWithJSR250.class);

        System.out.println("Calling destroy()");
        ctx.close();
        System.out.println("called destroy()");
    }
}
