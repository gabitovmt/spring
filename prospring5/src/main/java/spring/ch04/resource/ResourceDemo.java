package spring.ch04.resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("java:S106")
public class ResourceDemo {

    public static void main(String[] args) throws Exception {
        var ctx = new ClassPathXmlApplicationContext();
        var file = tempTestFile();

        Resource res1 = ctx.getResource("file:///" + file.getPath());
        displayInfo(res1);

        Resource res2 = ctx.getResource("classpath:spring/ch04/test.txt");
        displayInfo(res2);

        Resource res3 = ctx.getResource("https://www.google.com");
        displayInfo(res3);
    }

    private static void displayInfo(Resource res) throws IOException {
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println();
    }

    private static File tempTestFile() throws IOException {
        String filePath = System.getProperty("java.io.tmpdir") + File.separator + "test.txt";
        var file = new File(filePath);
        if (!file.createNewFile()) {
            System.err.println("ERROR: failed to create new file");
        }
        file.deleteOnExit();
        System.out.println("File exists: " + file.exists());

        return file;
    }
}
