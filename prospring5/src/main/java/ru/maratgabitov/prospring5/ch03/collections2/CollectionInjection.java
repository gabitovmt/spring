package ru.maratgabitov.prospring5.ch03.collections2;

import jakarta.annotation.Resource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {
    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set<Object> set;
    @Resource(name = "list")
    private List<Object> list;

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
        ctx.load("classpath:spring/ch03/collections2.xml");
        ctx.refresh();

        var instance = ctx.getBean("injectCollection", CollectionInjection.class);
        instance.displayInfo();

        ctx.close();
    }
}
