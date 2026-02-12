package spring.ch04.destroymethod;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

@SuppressWarnings("java:S106")
public class DestructiveBean implements InitializingBean {
    private File file;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
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

    public static void main(String[] args) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch04/destroy-method.xml");
        ctx.refresh();

        ctx.getBean("destructiveBean", DestructiveBean.class);

        System.out.println("Calling destroy()");
        ctx.close();
        System.out.println("Called destroy()");
    }
}
