package spring.ch03.collections;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set<Object> set;
    private List<Object> list;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @SuppressWarnings("java:S106")
    public void displayInfo() {
        System.out.println("Map contents:\n");
        for (var e : map.entrySet()) {
            System.out.printf("Key: %s - Value: %s%n", e.getKey(), e.getValue());
        }

        System.out.println("\nProperties contents:\n");
        for (var e : props.entrySet()) {
            System.out.printf("Key: %s - Value: %s%n", e.getKey(), e.getValue());
        }

        System.out.println("\nSet contents:\n");
        for (var obj : set) {
            System.out.printf("Value: %s%n", obj);
        }

        System.out.println("\nList contents:\n");
        for (var obj : list) {
            System.out.printf("Value: %s%n", obj);
        }
    }

    public static void main(String[] args) {
        var ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch03/collections.xml");
        ctx.refresh();

        var instance = ctx.getBean("injectCollection", CollectionInjection.class);
        instance.displayInfo();

        ctx.close();
    }
}
