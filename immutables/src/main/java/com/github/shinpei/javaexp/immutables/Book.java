package com.github.shinpei.javaexp.immutables;

import com.github.shinpei.javaexp.immutables.style.MyStyle;
import org.immutables.value.Value;

@Value.Immutable
@MyStyle
public abstract class Book {

    /**
     * It's mandatory param, if we specify parameter
     * @return
     */
    @Value.Parameter
    abstract int price();

    @Value.Parameter
    abstract int weight();

    /**
     * from java8, we can use default to set,
     * @return
     */
    @Value.Default
    String title() {
        return "no title";
    }

    final static double TAX_RATE = 1.08;

    @Value.Derived
    double priceWithTax() {
        return price() * TAX_RATE;
    }


    public final void bye() {
        System.out.println("Bye");
    }
}
