package spring.ch03.methodreplacement1;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class AbstractLookupDemoBean implements DemoBean {

    @Lookup("singer")
    @Override
    public Singer getMySinger() {
        // Переопределяется автоматически
        return null;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
