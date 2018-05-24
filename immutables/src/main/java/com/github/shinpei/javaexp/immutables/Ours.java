package com.github.shinpei.javaexp.immutables;

import com.github.shinpei.javaexp.immutables.style.MyStyle;
import org.immutables.value.Value;

@Value.Immutable
@MyStyle
public interface Ours {

    /**
     * It's mandatory param, if we specify parameter
     * @return
     */
    @Value.Parameter
    int hoge();

    @Value.Parameter
    int fuga();

    /**
     * from java8, we can use default to set,
     * @return
     */
    default int hi() {
        return 3;
    }

    default void bye() {
        System.out.println("Bye");
    }
}
