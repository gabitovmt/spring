package spring.ch03.hierarchical;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var parent = new GenericXmlApplicationContext();
        parent.load("classpath:spring/ch03/parent-context.xml");
        parent.refresh();

        var child = new GenericXmlApplicationContext();
        child.load("classpath:spring/ch03/child-context.xml");
        child.setParent(parent);
        child.refresh();

        var song1 = child.getBean("song1", Song.class);
        var song2 = child.getBean("song2", Song.class);
        var song3 = child.getBean("song3", Song.class);

        System.out.println("from parent ctx: " + song1.getTitle());
        System.out.println("from child ctx: " + song2.getTitle());
        System.out.println("from parent ctx: " + song3.getTitle());

        child.close();
        parent.close();
    }
}
