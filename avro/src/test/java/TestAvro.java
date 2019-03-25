import example.avro.User;

import org.apache.avro.Schema;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAvro {
    private final Logger logger = LoggerFactory.getLogger(TestAvro.class);

    @Test
    public void test () {
        Schema test = User.SCHEMA$;
        AvroSerializer serializer = new AvroSerializer();
        User user = User.newBuilder()
                .setName("hoge")
                .setFavoriteNumber(3)
                .setFavoriteColor("red")
                .build();
        logger.info("{}", user);
        byte[] bytes = serializer.serializeAvro(user);
        logger.info("{}", new String(bytes));

    }
}
