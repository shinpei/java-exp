import org.junit.jupiter.api.Test;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;


public class TestSpliterator {

    @Test
    public void spliterator() {

        IntStream.range(0, 3).spliterator().forEachRemaining((IntConsumer) System.out::println);

    }

}
