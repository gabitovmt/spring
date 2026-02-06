package spring.ch03.collections2;

import org.springframework.stereotype.Service;
import spring.ch03.collections.ContentHolder;

@Service("lyricHolder")
public class LyricHolder implements ContentHolder {
    private static final String VALUE = "'You be the DJ, I'll be the driver";

    @Override
    public String toString() {
        return "LyricHolder {" + VALUE + "}";
    }
}
