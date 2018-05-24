package com.github.shinpei.javaexp.immutables.style;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * You can create style like this if it is annoying to
 * define style each time
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Value.Style(
        defaults = @Value.Immutable(copy = false)
)
public @interface MyStyle {
}
