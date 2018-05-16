import com.google.common.collect.FluentIterable;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class TestFluent {

    private static final Logger logger = LoggerFactory.getLogger(TestFluent.class);

    @Test
    evoid test() {
        List<Integer> lst = Arrays.asList(1,2,3);
        List<Integer> lst2 = FluentIterable
                .from(lst)
                .toList();
        logger.info("{}", lst2);

    }
}
