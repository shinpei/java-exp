import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestFluent {

    private static final Logger logger = LoggerFactory.getLogger(TestFluent.class);

    @Test
    void transform() {
        List<Integer> lst = Arrays.asList(1,2,3);
        List<Integer> lst2 = FluentIterable
                .from(lst)
                .transform(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer val) {
                        return val * 2;
                    }
                })
                .toList();
        logger.info("{}", lst2);

        List<Integer> lst3 = lst
                .stream()
                .map(integer -> integer * 2)
                .collect(Collectors.toList());
        logger.info("{}", lst3);

    }

    @Test
    void combination () {

        List<String> lst = Arrays.asList("coffee", "tea", "beer");
        List<String> lst2 = Arrays.asList("American", "British", "Jamaican");

        List<String> lst3 = FluentIterable.from(lst)
                .transformAndConcat(new Function<String, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(String s) {
                        return FluentIterable.from(lst2).transform(v -> v + " " + s);
                    }
                }).toList();


    }


}
