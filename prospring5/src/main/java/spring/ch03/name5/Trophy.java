package spring.ch03.name5;

import org.springframework.core.annotation.AliasFor;

@Award
public @interface Trophy {

    @AliasFor(annotation = Award.class, attribute = "value")
    String[] name() default {};
}
