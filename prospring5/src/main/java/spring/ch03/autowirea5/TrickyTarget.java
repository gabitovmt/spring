package spring.ch03.autowirea5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@SuppressWarnings("java:S106")
public class TrickyTarget {

    @Autowired
    @Qualifier("fooImplOne")
    public void setFooOne(Foo fooOne) {
        System.out.println("Property fooOne set");
    }

    @Autowired
    @Qualifier("fooImplTwo")
    public void setFooTwo(Foo fooTwo) {
        System.out.println("Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar) {
        System.out.println("Property bar set");
    }
}
