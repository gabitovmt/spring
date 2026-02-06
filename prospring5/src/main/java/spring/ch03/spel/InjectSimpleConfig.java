package spring.ch03.spel;

import org.springframework.stereotype.Component;

@Component
public class InjectSimpleConfig {
    private static final String NAME = "John Mayer";
    private static final int AGE = 39;
    private static final float HEIGHT = 1.92f;
    private static final boolean PROGRAMMER = false;
    private static final Long AGE_IN_SECONDS = 1_241_401_112L;

    public String getName() {
        return NAME;
    }

    public int getAge() {
        return AGE;
    }

    public float getHeight() {
        return HEIGHT;
    }

    public boolean isProgrammer() {
        return PROGRAMMER;
    }

    public Long getAgeInSeconds() {
        return AGE_IN_SECONDS;
    }
}
