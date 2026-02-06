package spring.ch04.nameaware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component("johnMayer")
public class NamedSinger implements BeanNameAware {
    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @SuppressWarnings("java:S106")
    public void sing() {
        System.out.println("Singer " + name + " - sing()");
    }
}
