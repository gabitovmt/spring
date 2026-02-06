package spring.ch03.name2;

import org.springframework.stereotype.Component;

@Component("johnMayer")
public class Singer {
    private static final String LYRIC = "We found a message in a bottle we were drinking";

    @SuppressWarnings("java:S106")
    public void sing() {
        System.out.println(LYRIC);
    }
}
