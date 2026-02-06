package spring.ch04.custompropertyeditor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomEditorExample {
    private FullName name;

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch04/custom-property-editor.xml");

        var bean = ctx.getBean("exampleBean", CustomEditorExample.class);
        System.out.println(bean.getName());

        ctx.close();
    }
}
