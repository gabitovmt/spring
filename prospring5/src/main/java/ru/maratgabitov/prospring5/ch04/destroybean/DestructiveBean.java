package ru.maratgabitov.prospring5.ch04.destroybean;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("java:S106")
public class DestructiveBean {
    private File file;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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
    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file");
        }

        System.out.println("File exists: " + file.exists());
    }
}
