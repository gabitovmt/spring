package spring.ch03.simpletypes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectSimple {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("spring/ch03/inject-simple.xml");
        System.out.println(ctx.getBean("injectSimple1"));
        System.out.println(ctx.getBean("injectSimple2"));
        System.out.println(ctx.getBean("injectSimple3"));
        ctx.close();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
