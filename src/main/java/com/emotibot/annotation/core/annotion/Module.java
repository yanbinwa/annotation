package com.emotibot.annotation.core.annotion;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Module {
    @AliasFor(annotation = Component.class,attribute = "value")
    String name() default "";
    @AliasFor(annotation = Component.class)
    String value() default "";
    int timeout() default -1;
    Class<?>[] parent() default {};
}
