import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.Stores;

import java.util.Properties;

public class TopologyExample {

    public static void main (String[] args) {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "topology-exp1");
        config.put(StreamsConfig.CLIENT_ID_CONFIG, "my-client");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.99.100:9092");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        Topology tp = new Topology();
        tp
                .addSource("my-test", "test")
                .addProcessor("myprocess", MyProcessor::new, "my-test")
                .addStateStore(Stores.keyValueStoreBuilder(
                        Stores.inMemoryKeyValueStore("kvstore"),
                        Serdes.String(),
                        Serdes.String()
                ), "myprocess")
                .addSink("my-sink", "test-out", Serdes.String().serializer(), Serdes.String().serializer(), "myprocess");
    }


    static class MyProcessor implements Processor<String, String> {


        @Override
        public void init(ProcessorContext processorContext) {

        }

        @Override
        public void process(String s, String s2) {
            System.out.println(s + s2);

        }

        @Override
        public void close() {

        }
    }
}
