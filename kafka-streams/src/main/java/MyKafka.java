import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class MyKafka {


    static private void println(String a, String b) {
        System.out.println("k=" + a + ", v=" + b);
    }

    static public void main (String[] args) {

        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "mytest");
        config.put(StreamsConfig.CLIENT_ID_CONFIG, "my-client");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.99.100:9092");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> stream = builder.stream("test");
        stream.foreach((k, v) -> println(k, v));
        KafkaStreams ks = new KafkaStreams(builder.build(), config);


        ks.cleanUp();
        ks.start();

    }
}
