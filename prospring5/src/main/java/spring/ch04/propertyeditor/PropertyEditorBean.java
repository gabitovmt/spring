package spring.ch04.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

@SuppressWarnings({"java:S106", "java:S1068", "java:S1450"}) // Для учебных целей
public class PropertyEditorBean {
    private byte[] bytes;           // ByteArrayPropertyEditor
    private Character character;    // CharacterEditor
    private Class<?> cls;           // ClassEditor
    private Boolean trueOrFalse;    // CustomBooleanEditor
    private List<String> stringList;// CustomCollectionEditor
    private Date date;              // CustomDateEditor
    private Float floatValue;       // CustomNumberEditor
    private File file;              // FileEditor
    private InputStream stream;     // InputStreamEditor
    private Locale locale;          // LocaleEditor
    private Pattern pattern;        // PatternEditor
    private Properties properties;  // PropertiesEditor
    private String trimString;      // StringTrimmerEditor
    private URL url;                // URLEditor

    public static void main(String[] args) throws Exception {
        Path tmpDir  = Path.of(System.getProperty("java.io.tmpdir"));
        Path myFile  = tmpDir.resolve("test.txt");
        if (!Files.exists(myFile)) {
            Files.createFile(myFile);
        }
        myFile.toFile().deleteOnExit();

        var ctx = new ClassPathXmlApplicationContext("spring/ch04/property-editor.xml");
        ctx.getBean("builtInSample");
        ctx.close();
    }

    public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
        @Override
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            var dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
            registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }

    public void setBytes(byte... bytes) {
        System.out.println("Setting bytes: " + Arrays.toString(bytes));
        this.bytes = bytes;
    }

    public void setCharacter(Character character) {
        System.out.println("Setting character: " + character);
        this.character = character;
    }

    public void setCls(Class<?> cls) {
        System.out.println("Setting class: " + cls.getName());
        this.cls = cls;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Setting Boolean: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("Setting string list with size: " + stringList.size());
        this.stringList = stringList;
    }

    public void setDate(Date date) {
        System.out.println("Setting date: " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("Setting float value: " + floatValue);
        this.floatValue = floatValue;
    }

    public void setFile(File file) {
        System.out.println("Setting file: " + file.getName());
        this.file = file;
    }

    public void setStream(InputStream stream) {
        System.out.println("Setting stream: " + stream);
        this.stream = stream;
    }

    public void setLocale(Locale locale) {
        System.out.println("Setting locale: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        System.out.println("Loaded " + properties.size() + " properties");
        this.properties = properties;
    }

    public void setTrimString(String trimString) {
        System.out.println("Setting trim string: " + trimString);
        this.trimString = trimString;
    }

    public void setUrl(URL url) {
        System.out.println("Setting URL: " + url.toExternalForm());
        this.url = url;
    }
}
